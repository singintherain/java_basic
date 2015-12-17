package com.lvsong;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by lvsong on 7/8/15.
 */
public class OrderTest {
    private Customer customer;

    @Before
    public void setup() {
        this.customer = new Customer();
    }

    @Test
    public void dynamicMethodTest() {
//        customer.createOrder(new Pen());
        customer.createProxyOrder(new Pen());
    }
}
