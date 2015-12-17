package com.lvsong;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lvsong on 7/14/15.
 */
public class LogOrderServiceCGLib implements MethodInterceptor {
    public static OrderServiceInterf proxyService(OrderServiceInterf service) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(service.getClass());
        enhancer.setCallback(new LogOrderServiceCGLib());

        OrderServiceInterf orderService = (OrderServiceInterf) enhancer.create();

        return orderService;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log(method.getName());
        return methodProxy.invokeSuper(o, objects);
    }

    private void log(String msg) {
        System.out.println("log: " + msg);
    }
}
