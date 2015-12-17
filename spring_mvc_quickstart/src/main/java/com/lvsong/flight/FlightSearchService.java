package com.lvsong.flight;

import java.util.List;

/**
 * Created by lvsong on 7/15/15.
 */
public interface FlightSearchService {
    List<SpecialDeal> getSpecialDeal();

    List<Flight> findFlights(FlightSearchCriteria searchCriteria);
}
