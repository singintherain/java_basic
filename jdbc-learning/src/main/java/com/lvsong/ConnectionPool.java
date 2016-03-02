package com.lvsong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by lvsong on 12/24/15.
 */
@Component
public class ConnectionPool {
    private static final Log LOG = LogFactory.getLog(ConnectionPool.class);

    private int size = 3;
    private MyConnection[] myConnections;

    @Autowired
    private ConnectionFactory jdbcConnectionFactory;

    public ConnectionPool() {
    }

    public ConnectionPool(int size) {
        this.size = size;
    }

    @PostConstruct
    public void init() {
        myConnections = new MyConnection[size];

        for(int i = 0; i < size; i++) {
            myConnections[i] = jdbcConnectionFactory.getMyConnection();
            myConnections[i].setId(i);
        }

        LOG.info("初始化数据库连接池，共创建了" + size + "个连接");
    }

    public MyConnection getConnection() throws NoIdleConnectionException {
        synchronized (this) {
            for(MyConnection connection : myConnections) {
                if(connection.isIdle()) {
                    connection.setIdle(false);

                    return connection;
                }
            }

            throw new NoIdleConnectionException();
        }
    }
}
