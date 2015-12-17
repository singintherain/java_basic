package com.lvsong;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 * Created by lvsong on 6/28/15.
 */
public class DefaultInvocation implements Invocation{
    private List<Interceptor> interceptorList = new LinkedList<Interceptor>();
    private Iterator<Interceptor> interceptors;
    private Object businessObject;
    private BusinessObjectProxy proxy;

    public DefaultInvocation(Object businessObject){
        this.businessObject = businessObject;
    }

    public void init(BusinessObjectProxy proxy) {
        this.proxy = proxy;
        interceptors = interceptorList.iterator();

    }

    public void addInterceptor(Interceptor interceptor) {
        interceptorList.add(interceptor);
    }

    public void removeInterceptor(Interceptor interceptor) {
        interceptorList.remove(interceptor);
    }

    public Object invoke() throws Exception {
        // some other logic

        Object result = null;
        try {
            if (interceptors.hasNext()) {
                Interceptor interceptor = interceptors.next();
                interceptor.intercept(this);
            } else {
                result = invokeBusinessObjectMethod();
            }
        } catch (Exception e) {
            throw e;
        }

        return result;
    }

    public BusinessObjectProxy getProxy() {
        return proxy;
    }

    private Object invokeBusinessObjectMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        String methodName = proxy.getConfig().getMethodName();

        return businessObject.getClass().getMethod(methodName).invoke(businessObject);
    }
}
