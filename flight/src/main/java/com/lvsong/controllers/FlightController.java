package com.lvsong.controllers;

import com.lvsong.services.FlightSearchService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lvsong on 7/15/15.
 */
public class FlightController extends AbstractController {

    private static final int FIVE_MINUTES = 5*60;
    private FlightSearchService flightService;

    public FlightController() {
        setSupportedMethods(new String[]{METHOD_GET});
        setCacheSeconds(FIVE_MINUTES);
    }

    public void setFlightService(FlightSearchService flightService) {
        this.flightService = flightService;
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws Exception
    {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("specials", flightService.getSpecialDeal());
        return mv;
    }
}
