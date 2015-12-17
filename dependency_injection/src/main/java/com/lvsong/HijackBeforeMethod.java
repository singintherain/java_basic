package com.lvsong;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lvsong on 7/13/15.
 */
public class HijackBeforeMethod implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before action");
    }
}
