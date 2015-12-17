package com.lvsong.staticProxy;

/**
 * Created by lvsong on 7/10/15.
 */
//public abstract class HappyPeople {
//    public void celebrate() {
//        subscribeTicket();
//        travel();
//        System.out.println("celebrate");
//    }
//
//    private void subscribeTicket() {
//        System.out.println("subscribe ticket");
//    }
//    protected abstract void travel();
//}

public interface HappyPeople {
        public void celebrate();
        public void subscribeTicket();
        public void travel();
}
