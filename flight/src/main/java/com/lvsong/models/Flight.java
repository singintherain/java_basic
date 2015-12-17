package com.lvsong.models;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by lvsong on 7/15/15.
 */
public class Flight {

    private List<FlightLeg> legs;
    private BigDecimal totalCost;

    public Flight(List<FlightLeg> legs, BigDecimal totalCost) {
        Assert.notNull(legs);
        Assert.isTrue(legs.size() >= 1, "Flight must have at least one leg");
        this.legs = legs;
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalCost() {
        return this.totalCost;
    }

    public boolean isNonStop() {
        return (legs.size() == 1);
    }

    public Airport getDepartFrom() {
        return this.getFirstLeg().getDepartFrom();
    }

    private FlightLeg getFirstLeg() {
        return legs.get(0);
    }

    private FlightLeg getLastLeg() {
        return legs.get(legs.size() - 1);
    }

    public Airport getArriveAt() {
        return getLastLeg().getArriveAt();
    }

    public int getNumberOfLegs() {
        return legs.size();
    }

    public long getTotalTravelTime() {
        Date start = getFirstLeg().getDepartOn();
        Date end = getLastLeg().getArriveOn();
        Assert.isTrue(end.compareTo(start) > 0, "start date must be before end date");

        return (end.getTime() - start.getTime());
    }

}
