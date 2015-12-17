package com.lvsong.dynamic;

/**
 * Created by lvsong on 7/10/15.
 */
public abstract class HappyPeople {
    public void celebrate() {
        subscribeTicket();
        travel();
        System.out.println("celebrate");
    }

    private void subscribeTicket() {
        System.out.println("subscribe ticket");
    }
    protected abstract void travel();
}
