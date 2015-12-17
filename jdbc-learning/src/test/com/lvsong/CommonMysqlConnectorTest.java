package com.lvsong;

import com.lvsong.jpa.CommonMysqlConnector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by lvsong on 8/30/15.
 */
public class CommonMysqlConnectorTest {
    CommonMysqlConnector connector;

    @Before
    public void setUp() {
        connector = new CommonMysqlConnector("src/main/resources/mysql.properties");
    }

    @After
    public void clearDown() {}

    @Test
    public void getConnectionTest() {
        Connection connection1 = connector.getConnection();

        Assert.assertNotNull(connection1);

        System.out.println(connection1);

        Connection connection2 = connector.getConnection();

        Assert.assertNotNull(connection2);

        System.out.println(connection2);

//        try {
//            Thread.sleep(1000 * 20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
