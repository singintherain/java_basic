package com.lvsong;

/**
 * Created by lvsong on 6/29/15.
 */
public class BusinessObjectProxy {
    private Invocation invocation;
    private Config config;

    public BusinessObjectProxy(Invocation invocation, Config config){
        this.invocation = invocation;
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }
}
