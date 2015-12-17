package com.lvsong.passenger;

import java.sql.SQLSyntaxErrorException;

/**
 * Created by lvsong on 7/7/15.
 */
public class PassengerByAir extends HappyPeople {
    @Override
    protected void travel() {
        System.out.println("travel by air");
    }
}
