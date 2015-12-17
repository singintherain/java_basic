package com.lvsong;

/**
 * Created by lvsong on 7/8/15.
 */
public class Customer {
    public void createOrder(Product product) {
        OrderService orderService = new DefaultOrderService();

        orderService.selectProduct(product);
        orderService.submit();
        orderService.pay();
    }

    public void createProxyOrder(Product product) {
        OrderService orderService = OrderServiceProxy.proxyService(new DefaultOrderService());

        orderService.selectProduct(product);
        orderService.submit();
        orderService.pay();
    }
}
