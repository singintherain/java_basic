package com.lvsong;

/**
 * Created by lvsong on 7/9/15.
 */
public class Submit implements IAction {
//    IAction click = new Click();
//    IAction click = IActionProxy.newProxy(new Click());
    private IAction click;

    public Submit(IAction click) {
        this.click = click;
    }

    public IAction getClick() {
        return click;
    }

    public void setClick(IAction click) {
        this.click = click;
    }

    public void run() {
        System.out.println("submit");
        click.run();
    }
}
