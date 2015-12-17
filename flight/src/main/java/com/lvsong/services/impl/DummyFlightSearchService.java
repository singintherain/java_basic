package com.lvsong.services.impl;

import com.lvsong.models.*;
import com.lvsong.services.FlightSearchService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lvsong on 7/15/15.
 */
public class DummyFlightSearchService implements FlightSearchService {
    public List<SpecialDeal> getSpecialDeal() {
        List<SpecialDeal> specialDeals = new LinkedList<SpecialDeal>();

        specialDeals.add(new SpecialDeal(
                new Airport("Beijing", "1024"), new Airport("Jinan", "1025"),
                new BigDecimal(20), new Date(2014, 1, 2), new Date(2014, 1, 5)));

        specialDeals.add(new SpecialDeal(
                new Airport("Beijing", "1024"), new Airport("Hangzhou", "1026"),
                new BigDecimal(20), new Date(2014, 1, 2), new Date(2014, 1, 5)));

        System.out.println("-----" + specialDeals.size());
        return specialDeals;
    }

    public List<Flight> findFlights(FlightSearchCriteria searchCriteria) {
        List<Flight> flights = new LinkedList<Flight>();

        Airport beijing = new Airport("Beijing", "1024");
        Airport hangzhou = new Airport("Hangzhou", "1026");
        Airport jinan = new Airport("Jinan", "1025");
        Airport shanghai = new Airport("Shanghai", "1027");
        Airport guangzhou = new Airport("GuangZhou", "1028");

        FlightLeg beijing_hangzhou = new FlightLeg(beijing, new Date(2014,1,2), hangzhou, new Date(2014, 1, 5));
        FlightLeg hangzhou_shanghai = new FlightLeg(hangzhou, new Date(2014, 1, 5), shanghai, new Date(2014, 1, 6));

        List<FlightLeg> beijing_shanghai = new LinkedList<FlightLeg>();
        beijing_shanghai.add(beijing_hangzhou);
        beijing_shanghai.add(hangzhou_shanghai);

        flights.add(new Flight(beijing_shanghai, new BigDecimal(50)));


        return flights;
    }
}
