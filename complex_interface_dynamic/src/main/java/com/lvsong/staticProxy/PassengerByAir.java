package com.lvsong.staticProxy;

/**
 * Created by lvsong on 7/10/15.
 */
//public class PassengerByAir extends HappyPeople {
//    @Override
//    protected void travel() {
//        System.out.println("travel by air");
//    }
//}
public class PassengerByAir implements HappyPeople {
    public void celebrate() {
        subscribeTicket();
        travel();
        System.out.println("celebrate");
    }

    public void subscribeTicket() {
        System.out.println("subscribe ticket");
    }

    public void travel() {
        System.out.println("travel by air");
    }
}
