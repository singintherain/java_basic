package com.lvsong;

import org.junit.Test;

/**
 * Created by lvsong on 7/10/15.
 */
public class DynamicProxyTest {
    @Test
    public void runTest() {
        IAction order = ActionDynamicProxy.newProxy(new Order());
        order.run();
    }
}
