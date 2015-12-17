package com.lvsong;

import org.junit.Test;

/**
 * Created by lvsong on 7/13/15.
 */
public class ClassProxyTest {
    @Test
    public void classTest() {
        DefaultOrderService defaultOrderService = TestClassProxy.proxyService(new DefaultOrderService());
    }
}
