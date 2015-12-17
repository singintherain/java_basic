package com.lvsong.controllers;

import com.lvsong.services.FlightSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvsong on 7/17/15.
 */
@Controller
@RequestMapping("flight")
public class SearchFlightsController {

    @RequestMapping("search")
    public String index() {
        return "search";
    }
}
