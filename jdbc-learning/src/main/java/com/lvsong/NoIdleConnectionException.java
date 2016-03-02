package com.lvsong;

/**
 * Created by lvsong on 12/24/15.
 */
public class NoIdleConnectionException extends Exception {
    private static final String ERROR = "没有空闲的数据库连接";

    public NoIdleConnectionException() {
        super(ERROR);
    }

    public NoIdleConnectionException(String msg) {
        super(msg);
    }
}
