package com.lvsong;

/**
 * Created by lvsong on 7/10/15.
 */
public class Order implements IAction {
    public void run() {
        System.out.println("order ");
        IAction click = new Click();

        click.run();
    }
}
