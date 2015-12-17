package com.lvsong.staticProxy;

import com.lvsong.staticProxy.*;
import com.lvsong.staticProxy.PassengerByAir;
import org.junit.Test;

/**
 * Created by lvsong on 7/10/15.
 */
public class HappyPeopleHandlerTest {
    @Test
    public void celebrateTest() {
        HappyPeople happyPeople = HappyPeopleHander.newProxy(new PassengerByAir());
        happyPeople.celebrate();
    }
}
