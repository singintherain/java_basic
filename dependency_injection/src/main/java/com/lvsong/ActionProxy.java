package com.lvsong;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lvsong on 7/12/15.
 */
//public class ActionProxy implements MethodInterceptor {

////    public static IAction newProxy(IAction delegate) {
////        Enhancer enhancer = new Enhancer();
////        enhancer.setSuperclass(delegate.getClass());
////        enhancer.setCallback(new ActionProxy());
////
////        IAction action = (IAction)enhancer.create();
////
////        return action;
////    }
//
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println("proxy intercept");
//        return methodProxy.invokeSuper(o,  objects);
//    }
//}

public class ActionProxy implements InvocationHandler {
    private IAction action;

    public ActionProxy(IAction action) {
        this.action = action;
    }

    public ActionProxy() {}

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy intercept");
        return method.invoke(action, args);
    }
}
