package com.lvsong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvsong on 7/15/15.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/mvc")
    //host:port/hello/mvc
    public String helloMvc() {
        return "home";
    }
}
