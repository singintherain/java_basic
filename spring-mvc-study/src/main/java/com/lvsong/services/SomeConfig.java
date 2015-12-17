package com.lvsong.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by lvsong on 7/23/15.
 */
@Resource
public class SomeConfig {

    private static SomeConfig instance = null;

    public int number() {
        return 1;
    }

    @PostConstruct
    public void init(){
       instance = this;
    }

    public static SomeConfig getInstance(){
        return instance;
    }
}
