package com.lvsong;

import com.lvsong.domain.future.CallbackExecuteTask;
import com.lvsong.domain.future.FuturePool;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * Created by lvsong on 2/21/16.
 */
public class CallbackSqlExecuteTaskTest {
    private static final int futurePoolSize = 5;

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
    public void callbackTask() {
        for(int i = 0; i < 5; i++)
            futurePool.submit(new CallbackExecuteTask(connectionPool, new TaskBodyIntef() {
                public void start(MyConnection myConnection) throws Exception {
                    Connection connection = myConnection.getConnection();

                    try {
                        connection.setAutoCommit(false);
                        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                        Statement statement = connection.createStatement();

                        String openId = randomOpenId(Thread.currentThread().getId());
                        String insertSql = "INSERT INTO users(open_id) VALUES ('aaa" + openId + "bbb');";
                        System.out.println(Thread.currentThread() + "执行如下sql语句: " + insertSql);
                        int rows = statement.executeUpdate(insertSql);
                        String queryTotalCountsSql = "select count(*) from users;";
                        System.out.println(Thread.currentThread() + "执行如下sql语句: " + queryTotalCountsSql);
                        raiseException();
                        ResultSet resultSet = statement.executeQuery(queryTotalCountsSql);
                        connection.commit();
                    } catch (SQLException e) {
                        connection.rollback();
                        myConnection.free();
                        throw e;
                    } catch (Exception e) {
                        connection.rollback();
                        myConnection.free();
                        throw e;
                    }
//                    int totalRowCounts = resultSet.getInt(1);
//                    System.out.println(Thread.currentThread() + "查询users总行数: " + totalRowCounts);
                }
            }));

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String randomOpenId(long seed) {
        Random random = new Random(seed);
        return random.nextInt(10) + "";
    }

    public void raiseException() throws Exception {
        throw new Exception("在执行查询语句时报异常");
    }
}
