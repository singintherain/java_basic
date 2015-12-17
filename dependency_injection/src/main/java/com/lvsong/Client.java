package com.lvsong;

/**
 * Created by lvsong on 7/10/15.
 */
public class Client {
    private IAction sendKeys;
    private IAction createOrder;

    public void run() {
        getSendKeys().run();
        getCreateOrder().run();
    }

    public IAction getSendKeys() {
        return sendKeys;
    }

    public void setSendKeys(IAction sendKeys) {
        this.sendKeys = sendKeys;
    }

    public IAction getCreateOrder() {
        return createOrder;
    }

    public void setCreateOrder(IAction createOrder) {
        this.createOrder = createOrder;
    }
}
