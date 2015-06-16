package com.unisoft.algotrader.threading.disruptor.waitstrategy;

import org.junit.Test;

import static com.unisoft.algotrader.threading.disruptor.waitstrategy.WaitStrategyTestUtil.assertWaitForWithDelayOf;
/**
 * Created by alex on 6/9/15.
 */
public class YieldMultiBufferWaitStrategyTest {
    @Test
    public void shouldWaitForValue() throws Exception
    {
        assertWaitForWithDelayOf(100, new YieldMultiBufferWaitStrategy());
    }
}
