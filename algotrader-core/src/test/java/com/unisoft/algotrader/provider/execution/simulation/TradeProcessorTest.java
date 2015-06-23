package com.unisoft.algotrader.provider.execution.simulation;

import com.unisoft.algotrader.core.OrdType;
import com.unisoft.algotrader.core.Side;
import com.unisoft.algotrader.event.SampleEventFactory;
import com.unisoft.algotrader.event.data.Trade;
import com.unisoft.algotrader.event.execution.Order;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 6/6/15.
 */
public class TradeProcessorTest {
    private static TradeProcessor processor;
    private Order order;
    private Trade trade;

    @BeforeClass
    public static void init(){
        processor = new TradeProcessor();
    }

    @Before
    public void setup(){
        order = SampleEventFactory.createOrder(SampleEventFactory.testInstrument.instId, Side.Buy, OrdType.Limit, 800, 88);
        trade = SampleEventFactory.createTrade(SampleEventFactory.testInstrument.instId, 99, 500);
    }

    @Test
    public void test_price(){
        assertEquals(0.0 , processor.getPrice(order, null, null), 0.0);

        assertEquals(trade.price, processor.getPrice(order, trade, null), 0.0);
    }

    @Test
    public void test_qty(){
        assertEquals(order.ordQty, processor.getQty(order, trade, null), 0.0);
    }
}