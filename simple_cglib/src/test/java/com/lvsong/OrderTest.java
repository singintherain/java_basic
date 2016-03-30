package com.lvsong;

import org.junit.Test;

/**
 * Created by lvsong on 7/15/15.
 */
public class OrderTest {
    @Test
    public void test() {
        OrderServiceInterf orderServiceInterf = new DefaultOrder();

        OrderServiceInterf proxyOrder = LogOrderServiceProxy.proxyService(orderServiceInterf);
        proxyOrder.order();
    }
    @Test
    public void testCGLib() {
        DefaultOrder orderServiceInterf = new DefaultOrder();

        OrderServiceInterf proxyOrder = LogOrderServiceCGLib.proxyService(orderServiceInterf);
        proxyOrder.order();
    }
}
