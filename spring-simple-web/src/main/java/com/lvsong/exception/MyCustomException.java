package com.lvsong.exception;

/**
 * Created by lvsong on 9/9/15.
 */
public class MyCustomException extends Exception {
    private static final String msg = "my custom exception";

    public MyCustomException() {
        super(MyCustomException.msg);
    }
}
