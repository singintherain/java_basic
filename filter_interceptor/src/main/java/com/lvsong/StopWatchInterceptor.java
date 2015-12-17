package com.lvsong;

import org.omg.PortableInterceptor.*;

/**
 * Created by lvsong on 6/29/15.
 */
public class StopWatchInterceptor implements Interceptor{
//    private StopWatch stopWatch = new StopWatch();

    public Object intercept(Invocation invocation) throws Exception {
//        stopWatch.reset();

        Object result = invocation.invoke();

//        stopWatch.info("Method " + invocation.getProxy().getConfig().getMethodName() + "() used");

        return result;
    }
}
