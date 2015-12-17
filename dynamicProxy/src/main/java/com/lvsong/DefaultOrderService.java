package com.lvsong;

/**
 * Created by lvsong on 7/8/15.
 */
public class DefaultOrderService implements OrderService {
    public void selectProduct(Product product) {
        System.out.println("select product");
    }

    public void submit() {
        System.out.println("submit");
    }

    public void pay() {
        System.out.println("pay");
    }
}
