package com.lvsong;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lvsong on 7/13/15.
 */
public class TestClassProxy implements InvocationHandler{
    private DefaultOrderService service;

    public TestClassProxy(DefaultOrderService service) {
        this.service = service;
    }

    public static DefaultOrderService proxyService(DefaultOrderService service) {
        return (DefaultOrderService) Proxy.newProxyInstance(
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
