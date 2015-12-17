package com.lvsong.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lvsong on 7/10/15.
 */
public class HapplyPeopleHander implements MethodInterceptor {
    private static Set<String> methodNames;

    static {
        methodNames = new HashSet<String>();
        methodNames.add("celebrate");
        methodNames.add("subscribeTicket");
        methodNames.add("travel");
    }

    private boolean isMethodsQualified(Method method) {
        if(method == null) return false;

        return Modifier.isProtected(method.getModifiers()) && methodNames.contains(method.getName());
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result;

        boolean intercept = isMethodsQualified(method);

        if(intercept) {
            System.out.println("start timer");
        }

        result = methodProxy.invokeSuper(o, objects);

        if(intercept) {
            System.out.println("end timer");
        }

        return result;
    }

    public static HappyPeople newProxy(HappyPeople delegate) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(delegate.getClass());
        enhancer.setCallback(new HapplyPeopleHander());

        HappyPeople happyPeople = (HappyPeople) enhancer.create();
        return happyPeople;
    }
}
