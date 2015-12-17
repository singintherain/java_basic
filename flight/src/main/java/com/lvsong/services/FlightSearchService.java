package com.lvsong.services;

import com.lvsong.models.Flight;
import com.lvsong.models.FlightSearchCriteria;
import com.lvsong.models.SpecialDeal;

import java.util.List;

/**
 * Created by lvsong on 7/15/15.
 */
public interface FlightSearchService {
    List<SpecialDeal> getSpecialDeal();

    List<Flight> findFlights(FlightSearchCriteria searchCriteria);
}
