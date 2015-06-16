package com.unisoft.algotrader.provider.execution;

import com.lmax.disruptor.RingBuffer;
import com.unisoft.algotrader.core.OrdStatus;
import com.unisoft.algotrader.core.OrdType;
import com.unisoft.algotrader.core.Side;
import com.unisoft.algotrader.event.SampleEventFactory;
import com.unisoft.algotrader.event.data.MarketDataContainer;
import com.unisoft.algotrader.event.data.Quote;
import com.unisoft.algotrader.event.execution.ExecutionReport;
import com.unisoft.algotrader.event.execution.Order;
import com.unisoft.algotrader.order.OrderManager;
import com.unisoft.algotrader.provider.data.InstrumentDataManager;
import com.unisoft.algotrader.threading.disruptor.waitstrategy.NoWaitStrategy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static com.unisoft.algotrader.event.SampleEventFactory.createQuote;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by alex on 6/2/15.
 */
public class SimulationExecutorTest {

    private SimulationExecutor simulationExecutor;
    private OrderManager orderManager;
    private RingBuffer rb =RingBuffer.createSingleProducer(MarketDataContainer.FACTORY, 1024, new NoWaitStrategy());

    @Before
    public void setup(){
        orderManager = spy(new OrderManager());

        simulationExecutor = new SimulationExecutor(orderManager, InstrumentDataManager.INSTANCE, rb);
        simulationExecutor.config.fillOnBar = true;
        simulationExecutor.config.fillOnQuote = true;
        simulationExecutor.config.fillOnTrade = true;
        simulationExecutor.config.fillOnBarMode = SimulatorConfig.FillOnBarMode.LastBarClose;

        InstrumentDataManager.INSTANCE.clear();
    }

    private void assertNotFill(ExecutionReport er){
        assertEquals(OrdStatus.New, er.ordStatus);
        assertEquals(0.0, er.filledQty, 0.0);
    }
    private void assertFill(ExecutionReport er, double avgPx, double qty){
        assertEquals(OrdStatus.Filled, er.ordStatus);
        assertEquals(avgPx, er.avgPx, 0.0);
        assertEquals(qty, er.filledQty, 0.0);
    }

    @Test
    public void test_fill_market_order_immediate_on_current_quote(){
        InstrumentDataManager.INSTANCE.onQuote(createQuote(SampleEventFactory.testInstrument.instId, 89, 91, 98000, 98000));
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.Market, 98000, 0);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument1 = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(2)).onExecutionReport(argument1.capture());
        List<ExecutionReport> reportList = argument1.getAllValues();
        assertNotFill(reportList.get(0));

        ExecutionReport lastReport = reportList.get(reportList.size()-1);
        assertFill(lastReport, 91, order.ordQty);
    }

    @Test
    public void test_fill_market_order_on_next_quote(){
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.Market, 98000, 0);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument1 = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(1)).onExecutionReport(argument1.capture());
        ExecutionReport er = argument1.getValue();
        assertNotFill(er);

        simulationExecutor.onQuote(createQuote(SampleEventFactory.testInstrument.instId, 89, 91, 98000, 98000));

        ArgumentCaptor<ExecutionReport> argument2 = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(1)).onExecutionReport(argument2.capture());
        List<ExecutionReport> reportList = argument2.getAllValues();
        ExecutionReport lastReport = reportList.get(reportList.size()-1);
        assertFill(lastReport, 91, order.ordQty);
    }

    @Test
    public void test_fill_limit_order_on_current_quote(){

        InstrumentDataManager.INSTANCE.onQuote(createQuote(SampleEventFactory.testInstrument.instId, 89, 91, 98000, 98000));
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.Limit, 98000, 91);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument1 = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(2)).onExecutionReport(argument1.capture());
        List<ExecutionReport> reportList = argument1.getAllValues();
        ExecutionReport lastReport = reportList.get(reportList.size()-1);
        assertFill(lastReport, 91, order.ordQty);
    }

    @Test
    public void test_fill_limit_order_on_next_quote(){

        InstrumentDataManager.INSTANCE.onQuote(createQuote(SampleEventFactory.testInstrument.instId, 89, 91, 98000, 98000));
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.Limit, 98000, 89);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument1 = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(1)).onExecutionReport(argument1.capture());
        List<ExecutionReport> reportList = argument1.getAllValues();
        assertEquals(1, reportList.size());
        ExecutionReport lastReport = reportList.get(0);
        assertNotFill(lastReport);

        simulationExecutor.onQuote(createQuote(SampleEventFactory.testInstrument.instId, 86, 88, 98000, 98000));
        ArgumentCaptor<ExecutionReport> argument2 = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(1)).onExecutionReport(argument2.capture());
        reportList = argument2.getAllValues();
        lastReport = reportList.get(reportList.size()-1);
        assertFill(lastReport, 88, order.ordQty);
    }

    @Test
    public void test_fill_stop_order_on_current_quote(){
        Quote quote = createQuote(SampleEventFactory.testInstrument.instId, 89, 91, 98000, 98000);
        InstrumentDataManager.INSTANCE.onQuote(quote);
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.Stop, 98000, 0, 89.5);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument1 = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(2)).onExecutionReport(argument1.capture());
        List<ExecutionReport> reportList = argument1.getAllValues();
        assertEquals(2, reportList.size());
        ExecutionReport lastReport = reportList.get(1);
        assertFill(lastReport, quote.ask, order.ordQty);
    }

    @Test
    public void test_fill_stop_order_on_next_quote(){

        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.Stop, 98000, 0, 89.5);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument1 = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(1)).onExecutionReport(argument1.capture());
        List<ExecutionReport> reportList = argument1.getAllValues();
        assertEquals(1, reportList.size());
        ExecutionReport lastReport = reportList.get(0);
        assertNotFill(lastReport);


        simulationExecutor.onQuote(createQuote(SampleEventFactory.testInstrument.instId, 86, 90, 98000, 98000));

        ArgumentCaptor<ExecutionReport> argument2 = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(1)).onExecutionReport(argument2.capture());
        reportList = argument2.getAllValues();
        lastReport = reportList.get(reportList.size()-1);
        assertFill(lastReport, 90, order.ordQty);
    }

    @Test
    public void test_stop_limit_order_become_ready_on_next_quote(){
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.StopLimit, 98000, 85, 89.5);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(1)).onExecutionReport(argument.capture());
        List<ExecutionReport> reportList = argument.getAllValues();
        assertEquals(1, reportList.size());
        ExecutionReport lastReport = reportList.get(0);
        assertNotFill(lastReport);
        assertFalse(order.stopLimitReady);

        Quote quote = createQuote(SampleEventFactory.testInstrument.instId, 86, 90, 98000, 98000);
        simulationExecutor.onQuote(quote);

        argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(1)).onExecutionReport(argument.capture());
        reportList = argument.getAllValues();
        assertEquals(1, reportList.size());
        lastReport = reportList.get(0);
        assertNotFill(lastReport);
        assertTrue(order.stopLimitReady);

        quote = createQuote(SampleEventFactory.testInstrument.instId, 83, 84, 98000, 98000);
        simulationExecutor.onQuote(quote);
        argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(1)).onExecutionReport(argument.capture());
        reportList = argument.getAllValues();
        lastReport = reportList.get(reportList.size()-1);
        assertFill(lastReport, quote.ask, order.ordQty);

    }

    @Test
    public void test_stop_limit_order_become_ready_on_current_quote(){
        Quote quote = createQuote(SampleEventFactory.testInstrument.instId, 89, 91, 98000, 98000);
        InstrumentDataManager.INSTANCE.onQuote(quote);
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.StopLimit, 98000, 85, 89.5);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(1)).onExecutionReport(argument.capture());
        List<ExecutionReport> reportList = argument.getAllValues();
        assertEquals(1, reportList.size());
        ExecutionReport lastReport = reportList.get(0);
        assertNotFill(lastReport);
        assertTrue(order.stopLimitReady);

        quote = createQuote(SampleEventFactory.testInstrument.instId, 84, 85, 98000, 98000);
        simulationExecutor.onQuote(quote);
        argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(1)).onExecutionReport(argument.capture());
        reportList = argument.getAllValues();
        lastReport = reportList.get(reportList.size()-1);
        assertFill(lastReport, quote.ask, order.ordQty);
    }

    @Test
    public void test_fill_trailing_stop_order_on_next_quote(){

        Quote quote = createQuote(SampleEventFactory.testInstrument.instId, 89, 91, 98000, 98000);
        InstrumentDataManager.INSTANCE.onQuote(quote);
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.TrailingStop, 98000, 0, 10);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(1)).onExecutionReport(argument.capture());
        List<ExecutionReport> reportList = argument.getAllValues();
        assertEquals(1, reportList.size());
        ExecutionReport lastReport = reportList.get(0);
        assertNotFill(lastReport);
        assertEquals(101, order.trailingStopExecPrice, 0.0);

        quote = createQuote(SampleEventFactory.testInstrument.instId, 100, 101, 98000, 98000);
        simulationExecutor.onQuote(quote);
        argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(1)).onExecutionReport(argument.capture());
        reportList = argument.getAllValues();
        lastReport = reportList.get(reportList.size()-1);
        assertFill(lastReport, quote.ask, order.ordQty);

    }

    @Test
    public void test_change_trailing_exec_price_when_price_drop(){

        Quote quote = createQuote(SampleEventFactory.testInstrument.instId, 89, 91, 98000, 98000);
        InstrumentDataManager.INSTANCE.onQuote(quote);
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.TrailingStop, 98000, 0, 10);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(1)).onExecutionReport(argument.capture());
        List<ExecutionReport> reportList = argument.getAllValues();
        assertEquals(1, reportList.size());
        ExecutionReport lastReport = reportList.get(0);
        assertNotFill(lastReport);
        assertEquals(quote.ask + order.stopPx, order.trailingStopExecPrice, 0.0);


        quote = createQuote(SampleEventFactory.testInstrument.instId, 77, 78, 98000, 98000);
        simulationExecutor.onQuote(quote);
        argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(1)).onExecutionReport(argument.capture());
        reportList = argument.getAllValues();
        lastReport = reportList.get(reportList.size()-1);
        assertNotFill(lastReport);
        assertEquals(quote.ask + order.stopPx, order.trailingStopExecPrice, 0.0);
    }


    @Test
    public void test_no_change_trailing_exec_price_when_price_up(){

        Quote quote = createQuote(SampleEventFactory.testInstrument.instId, 89, 91, 98000, 98000);
        InstrumentDataManager.INSTANCE.onQuote(quote);
        Order order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.TrailingStop, 98000, 0, 10);
        orderManager.onOrder(order);

        ArgumentCaptor<ExecutionReport> argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, times(1)).onExecutionReport(argument.capture());
        List<ExecutionReport> reportList = argument.getAllValues();
        assertEquals(1, reportList.size());
        ExecutionReport lastReport = reportList.get(0);
        assertNotFill(lastReport);
        assertEquals(quote.ask + order.stopPx, order.trailingStopExecPrice, 0.0);


        quote = createQuote(SampleEventFactory.testInstrument.instId, 99, 100, 98000, 98000);
        simulationExecutor.onQuote(quote);
        argument = ArgumentCaptor.forClass(ExecutionReport.class);
        verify(orderManager, atLeast(1)).onExecutionReport(argument.capture());
        reportList = argument.getAllValues();
        lastReport = reportList.get(reportList.size()-1);
        assertNotFill(lastReport);
        assertEquals(91 + 10, order.trailingStopExecPrice, 0.0);
    }
}
