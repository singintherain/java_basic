package com.lvsong;

import org.junit.Test;

/**
 * Created by lvsong on 7/8/15.
 */
public class ActionTest {
    @Test
    public void startTest() {
        System.out.println("------------");
        System.out.println("Action1: ");
        ITopAction actioin1 = new Action1();
        actioin1.start();

        System.out.println("------------");
        System.out.println("Action2: ");
        ITopAction action2 = new Action2();
        action2.start();
    }
}
