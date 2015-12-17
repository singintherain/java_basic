package com.lvsong.passenger;

import org.junit.Test;

/**
 * Created by lvsong on 7/7/15.
 */
public class HappyPeopleTest {
    @Test
    public void celebrateTest() {
        HappyPeople passengerByAir = new PassengerByAir();
        HappyPeople passengerByCoach = new PassengerByCoach();
        HappyPeople passengerByTrain = new PassengerByTrain();

        System.out.println("Tom is going home!");
        passengerByAir.celebrateFestival();
        System.out.println("Rose is going home!");
        passengerByCoach.celebrateFestival();
        System.out.println("Hurry is going home!");
        passengerByTrain.celebrateFestival();
    }
}
