package com.lvsong;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lvsong on 7/8/15.
 */
public class SynchronizeHandler implements InvocationHandler {
    private Increasable delegate;

    public static Increasable newProxy(Increasable delegate) {
        Increasable increasable = (Increasable)(Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                new SynchronizeHandler(delegate)));

        return increasable;
    }

    public SynchronizeHandler(Increasable increasable) {
        this.delegate = delegate;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        synchronized (delegate) {
            return method.invoke(delegate, args);
        }
    }
}
