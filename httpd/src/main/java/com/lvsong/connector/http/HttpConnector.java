package com.lvsong.connector.http;

import java.net.ServerSocket;

/**
 * Created by lvsong on 9/20/15.
 */
public class HttpConnector implements Runnable {
    private boolean stopped;
    private String schema = "http";

    public String getSchema() {
        return schema;
    }

    public void run() {
        ServerSocket servletSocket = null;
        int port = 8080;
    }
}
