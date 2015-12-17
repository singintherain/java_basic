package com.lvsong;

/**
 * Created by lvsong on 7/8/15.
 */
public abstract class ITopAction {
    public void start () {
        method1();
        method2();
        abstractMethod3();
    }

    public void method1() {
        System.out.println("base method1");
    }

    public void method2() {
        System.out.println("base method2");
    }

    public abstract void abstractMethod3();
}
