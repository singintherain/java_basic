package com.lvsong;

/**
 * Created by lvsong on 6/28/15.
 */
public interface Invocation {
    void init(BusinessObjectProxy proxy);
    void addInterceptor(Interceptor interceptor);
    void removeInterceptor(Interceptor interceptor);
    Object invoke() throws Exception;
    BusinessObjectProxy getProxy();
}
