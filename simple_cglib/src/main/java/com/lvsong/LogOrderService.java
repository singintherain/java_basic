package com.lvsong;

/**
 * Created by lvsong on 7/14/15.
 */
public class LogOrderService implements OrderServiceInterf {
    private OrderServiceInterf defaultOrderService = new DefaultOrder();

    public void selectProduct(Product product) {
        log("selectProduct");
        defaultOrderService.selectProduct(product);
    }

    public void submit() {
        log("submit");
        defaultOrderService.submit();
    }

    public void pay() {
        log("pay");
        defaultOrderService.pay();
    }

    public void order() {

    }

    private void log(String msg) {
        System.out.println("log: " + msg);
    }
}
