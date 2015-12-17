package com.lvsong.dynamic;

import org.junit.Test;

/**
 * Created by lvsong on 7/10/15.
 */
public class HapplyPeopleHandlerTest {
    @Test
    public void celebrateTest() {
        HappyPeople passengerByAir = HapplyPeopleHander.newProxy(new PassengerByAir());
        passengerByAir.celebrate();
    }
}
