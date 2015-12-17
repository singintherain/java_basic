package com.lvsong;

/**
 * Created by lvsong on 7/14/15.
 */
public class DefaultOrder implements OrderServiceInterf{
    public void selectProduct(Product product) {
        System.out.println("default order select Product");
    }

    public void order() {
        System.out.println("order");
        Product pen = new Product();
        selectProduct(pen);
        submit();
        pay();
    }

    public void submit() {
        System.out.println("default order submit");
    }

    public void pay() {
        System.out.println("default order pay");
    }
}
