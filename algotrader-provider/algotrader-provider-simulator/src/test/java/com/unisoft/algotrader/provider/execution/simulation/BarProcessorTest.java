package com.unisoft.algotrader.provider.execution.simulation;

import com.unisoft.algotrader.event.SampleEventFactory;
import com.unisoft.algotrader.model.event.data.Bar;
import com.unisoft.algotrader.model.event.execution.Order;
import com.unisoft.algotrader.model.trading.OrdType;
import com.unisoft.algotrader.model.trading.Side;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 6/6/15.
 */
public class BarProcessorTest {

    private static BarProcessor processor;
    private Order order;
    private Bar bar;


    @BeforeClass
    public static void init(){
        processor = new BarProcessor();
    }

    @Before
    public void setup(){
        order = SampleEventFactory.createOrder(SampleEventFactory.TEST_HKD_INSTRUMENT.getInstId(), Side.Buy, OrdType.Limit, 800, 88);
        bar = SampleEventFactory.createBar(SampleEventFactory.TEST_HKD_INSTRUMENT.getInstId(), 87, 95, 60, 88);
    }

    @Test
    public void test_price(){
        SimulatorConfig config = new SimulatorConfig();
        config.fillOnBarMode = SimulatorConfig.FillOnBarMode.LastBarClose;
        assertEquals(bar.close, processor.getPrice(order, bar, config), 0.0);

        config.fillOnBarMode = SimulatorConfig.FillOnBarMode.NextBarOpen;
        assertEquals(bar.open, processor.getPrice(order, bar, config), 0.0);

        config.fillOnBarMode = SimulatorConfig.FillOnBarMode.NextBarClose;
        assertEquals(bar.close, processor.getPrice(order, bar, config), 0.0);
    }

    @Test
    public void test_qty(){
        assertEquals(order.ordQty, processor.getQty(order, bar, null), 0.0);
    }
}
