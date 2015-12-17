package com.lvsong.staticProxy;

import javax.net.ssl.SSLContext;

/**
 * Created by lvsong on 7/10/15.
 */
//public class PassengerByCoach extends HappyPeople {
//    @Override
//    protected void travel() {
//        System.out.println("travel by coach");
//    }
//}
public class PassengerByCoach implements HappyPeople {
    public void celebrate() {
        subscribeTicket();
        travel();
        System.out.println("celebrate");
    }

    public void subscribeTicket() {
        System.out.println("subscribe ticket");
    }

    public void travel() {
        System.out.println("travel by coach");
    }
}
