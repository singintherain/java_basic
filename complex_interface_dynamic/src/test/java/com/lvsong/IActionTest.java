package com.lvsong;

import org.junit.Test;

/**
 * Created by lvsong on 7/9/15.
 */
public class IActionTest {
    @Test
    public void adapterTest() {
        IAction action = IActionProxy.newProxy(new Submit(IActionProxy.newProxy(new Click())));
        action.run();
    }
}
