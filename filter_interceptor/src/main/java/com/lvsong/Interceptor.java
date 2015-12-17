package com.lvsong;

/**
 * Created by lvsong on 6/29/15.
 */
public interface Interceptor {
    Object intercept(Invocation invocation) throws Exception;
}
