package com.lvsong;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lvsong on 7/9/15.
 */
public class IActionProxy implements InvocationHandler{
    private IAction action;

    public IActionProxy(IAction action) {
        this.action = action;
    }

    public static IAction newProxy(IAction action) {
        return (IAction)Proxy.newProxyInstance(
                action.getClass().getClassLoader(),
                action.getClass().getInterfaces(),
                new IActionProxy(action)
        );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("run")) {
            System.out.println(proxy.getClass().getName() + method.getName());
            return method.invoke(action, args);
        } else {
            return method.invoke(action, args);
        }
    }
}
