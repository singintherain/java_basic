package com.lvsong;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lvsong on 7/14/15.
 */
public class LogOrderServiceProxy implements InvocationHandler {
    private OrderServiceInterf service;

    public LogOrderServiceProxy(OrderServiceInterf service) {
        this.service = service;
    }

    public static OrderServiceInterf proxyService(OrderServiceInterf service) {
        return (OrderServiceInterf) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new LogOrderServiceProxy(service)
        );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        return method.invoke(service, args);
    }

    private void log(String msg) {
        System.out.println("log: " + msg);
    }
}
