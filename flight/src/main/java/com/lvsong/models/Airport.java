package com.lvsong.models;

/**
 * Created by lvsong on 7/15/15.
 */
public class Airport {
    private String name;
    private String airportCode;

    public Airport(String name, String airportCode) {
        this.name = name;
        this.airportCode = airportCode;
    }

    public String getName() {
        return name;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public String toString() {
        return name + " (" + airportCode;
    }

}
