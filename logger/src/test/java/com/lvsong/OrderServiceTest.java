package com.lvsong;

import org.junit.Test;

/**
 * Created by lvsong on 7/16/15.
 */
public class OrderServiceTest {
    @Test
    public void createTest() {
        OrderService orderService = new OrderService();
        orderService.create();
    }
}
