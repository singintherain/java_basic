package com.lvsong.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lvsong on 9/9/15.
 */
public class PerformaceHandler implements InvocationHandler {
    private Object target;

    public PerformaceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(method.getName());
        Object object = method.invoke(target, args);
        PerformanceMonitor.end();

        return object;
    }
}
