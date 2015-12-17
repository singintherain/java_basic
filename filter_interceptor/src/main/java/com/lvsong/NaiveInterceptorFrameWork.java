package com.lvsong;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvsong on 6/29/15.
 */
public class NaiveInterceptorFrameWork {
    private static NaiveInterceptorFrameWork context;
    private Map<String, BusinessObjectProxy> services =
            new HashMap<String, BusinessObjectProxy>();

    public static void configure() {
//        load(new NaiveInterceptorFrameWork());
//
//        PassengerByAir passengerByAir = new PassengerByAir();
//
//        Invocation subscribeTicketInvocation = new DefaultInvocation(passengerByAir);
//        subscribeTicketInvocation.addInterceptor(StopWatchInterceptor);
//        BusinessObjectProxy subscribeTicket = ProxyFactory.createProxy(subscribeTicketInvocation, new Config("subscribeTicket"));
//        context.services.put("subscribeTicket", subscribeTicket);
//
//        Invocation travelInvocation = new DefaultInvocation(passengerByAir);
//        travelInvocation.addInterceptor(new StopWatchInterceptor());
//        BusinessObjectProxy travel = ProxyFactory.createProxy(travelInvocation, new Config("travel"));
//        context.services.put("travel", travel);
//
//        Invocation celebrateInvocation = new DefaultInvocation(passengerByAir);
//        celebrateInvocation.addInterceptor(StopWatchInterceptor);
//        BusinessObjectProxy celebrate = ProxyFactory.createProxy(celebrateInvocation, new Config("celebrate"));
//        context.services.put("celebrate", celebrate);
    }

    private static void load(NaiveInterceptorFrameWork naiveInterceptorFrameWork) {
        context = naiveInterceptorFrameWork;
    }

    public static BusinessObjectProxy lookup(String proxyName){
        return context.services.get(proxyName);
    }
}
