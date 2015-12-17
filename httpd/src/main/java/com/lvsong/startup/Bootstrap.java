package com.lvsong.startup;

import com.lvsong.connector.http.HttpConnector;

/**
 * Created by lvsong on 9/20/15.
 */
public final class Bootstrap {
    public static void main(String[] args) {
        HttpConnector httpConnector = new HttpConnector();
        httpConnector.run();
    }
}
