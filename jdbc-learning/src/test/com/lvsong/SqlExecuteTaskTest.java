package com.lvsong;

import com.lvsong.domain.future.FuturePool;
import com.lvsong.domain.future.SqlExecuteTask;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvsong on 12/24/15.
 */
public class SqlExecuteTaskTest {
    private static final int futurePoolSize = 5;
    private static final int connectionPoolSize = 3;

    private ApplicationContext applicationContext;
    private ConnectionPool connectionPool;
    private FuturePool futurePool;

    @Before
    public void startUp() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:/config/applicationContext.xml");
        connectionPool = applicationContext.getBean("connectionPool", ConnectionPool.class);
        futurePool = new FuturePool(futurePoolSize);
    }

    @Test
    public void executeTest() {
        String sql1 = "select count(*) from users;";
        String sql2 = "select count(*) from users;";
        String sql3 = "select count(*) from users;";
        String sql4 = "select count(*) from users;";
        String sql5 = "select count(*) from users;";
        String sql6 = "select count(*) from users;";

        List<String> sqlList = new ArrayList<String>();

        sqlList.add(sql1);
        sqlList.add(sql2);
        sqlList.add(sql3);
        sqlList.add(sql3);
        sqlList.add(sql4);
        sqlList.add(sql5);
        sqlList.add(sql6);
        sqlList.add(sql3);
        sqlList.add(sql3);

        for(String sql : sqlList) {
            SqlExecuteTask task = new SqlExecuteTask(connectionPool, sql);

            futurePool.submit(task);
        }

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
