package com.lvsong.passenger;

/**
 * Created by lvsong on 7/7/15.
 */
public abstract class HappyPeople {
    public final void celebrateFestival() {
        subscribeTicket();
        travel();
        celebrate();
    }

    private void subscribeTicket() {
        System.out.println("subscribe ticket");
    }

    protected abstract void travel();

    private void celebrate() {
        System.out.println("celebrate");
    }
}
