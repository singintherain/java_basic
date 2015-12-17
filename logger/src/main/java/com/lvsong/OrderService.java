package com.lvsong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lvsong on 7/16/15.
 */
public class OrderService {
    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void create() {
        logger.info("orderService create");
    }
}
