package com.lvsong;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lvsong on 7/8/15.
 */
public class OrderServiceProxy implements InvocationHandler {
    private OrderService service;

    public OrderServiceProxy(OrderService service) {
        this.service = service;
    }

    public static OrderService proxyService(OrderService service) {
        return (OrderService) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new OrderServiceProxy(service)
        );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("log: " + method.getName());
        return method.invoke(service, args);
    }
}
