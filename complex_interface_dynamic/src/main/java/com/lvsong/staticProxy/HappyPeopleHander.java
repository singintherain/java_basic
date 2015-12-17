package com.lvsong.staticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lvsong on 7/10/15.
 */
public class HappyPeopleHander implements InvocationHandler {
    private static Set<String> methodNames;
    private HappyPeople happyPeople;

    public HappyPeopleHander(HappyPeople happyPeople) {
        this.happyPeople = happyPeople;
    }

    static {
        methodNames = new HashSet<String>();
        methodNames.add("celebrate");
        methodNames.add("subscribeTicket");
        methodNames.add("travel");
    }

    private boolean isMethodsQualified(Method method) {
        if(method == null) return false;

//        return Modifier.isProtected(method.getModifiers()) && methodNames.contains(method.getName());
        return methodNames.contains(method.getName());
    }

    public static HappyPeople newProxy(HappyPeople delegate) {
        return (HappyPeople) Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                new HappyPeopleHander(delegate)
        );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;

        boolean intercept = isMethodsQualified(method);

        if(intercept) {
            System.out.println("start timer");
        }

        result = method.invoke(happyPeople, args);

        if(intercept) {
            System.out.println("end timer");
        }

        return result;
    }
}
