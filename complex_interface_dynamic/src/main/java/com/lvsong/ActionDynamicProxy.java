package com.lvsong;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lvsong on 7/10/15.
 */
public class ActionDynamicProxy implements MethodInterceptor{
    private static Set<String> methodNames;

    static {
        methodNames = new HashSet<String>();
        methodNames.add("run");
    }

    public static IAction newProxy(IAction delegate) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(delegate.getClass());
        enhancer.setCallback(new ActionDynamicProxy());

        IAction action = (IAction)enhancer.create();

        return action;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("run")) {
            System.out.println(methodProxy.getClass().getName() + method.getName());
            return methodProxy.invokeSuper(o, objects);
        } else {
            return methodProxy.invokeSuper(o, objects);
        }
    }
}
