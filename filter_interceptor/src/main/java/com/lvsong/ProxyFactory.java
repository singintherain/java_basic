package com.lvsong;

/**
 * Created by lvsong on 6/29/15.
 */
public class ProxyFactory {
    public static BusinessObjectProxy createProxy(Invocation invocation, Config config){
        BusinessObjectProxy proxy = new BusinessObjectProxy(invocation, config);

        invocation.init(proxy);

        return proxy;
    }
}
