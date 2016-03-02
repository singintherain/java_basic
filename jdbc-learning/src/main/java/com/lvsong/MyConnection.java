package com.lvsong;

import java.sql.Connection;

/**
 * Created by lvsong on 12/24/15.
 */
public class MyConnection {
    private int id;

    public MyConnection() {
        this.idle = true;
    }

    public void free() {
        setIdle(true);
    }
    /**
     * 可用状态
     */
    private boolean idle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * 数据源连接
     */
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }
}
