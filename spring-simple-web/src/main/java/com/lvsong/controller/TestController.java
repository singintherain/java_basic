package com.lvsong.controller;

import com.lvsong.exception.JsonException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lvsong on 9/10/15.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/runtimeException")
    public void index() {
        throw new RuntimeException("custom runtime exception");
    }

    @RequestMapping("/normalException")
    public void normalException() throws Exception {
        throw new Exception("normal exception");
    }

    @RequestMapping("/json")
    @ResponseBody
    public Object json() {
        return new String("json");
    }

    @RequestMapping("/json_runtime_exception")
    @ResponseBody
    public String jsonRunException() throws Exception{
        throw new JsonException("custom json runtime exception");
    }

    @RequestMapping("/json_normal_exception")
    @ResponseBody
    public String jsonNormalException() throws Exception{
        throw new JsonException("custom json normal exception");
    }
}
