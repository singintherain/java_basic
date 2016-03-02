package com.lvsong.domain.future;

import com.lvsong.ConnectionPool;
import com.lvsong.MyConnection;
import com.lvsong.NoIdleConnectionException;
import com.lvsong.TaskBodyIntef;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lvsong on 12/24/15.
 */
public class SqlExecuteTask implements Runnable {
    private static final Log LOG = LogFactory.getLog(SqlExecuteTask.class);

    private String sql;
    private ConnectionPool connectionPool;

    public SqlExecuteTask(ConnectionPool connectionPool, String sql) {
        this.connectionPool = connectionPool;
        this.sql = sql;
    }

    public void run() {
        while(true) {
            try {
                MyConnection myConnection = connectionPool.getConnection();
                Connection connection = myConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                LOG.info("Thread" + Thread.currentThread() + "使用数据库连接：" +
                        myConnection.getId()
                        + ", 执行sql命令成功: " + sql);

                myConnection.free();
                break;
            } catch (SQLException e) {
                LOG.error("生成sql的statement失败! " + e.getMessage());
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e1) {
                    LOG.info("休眠500ms");
                }
            } catch (NoIdleConnectionException e) {
                LOG.error("任务" + Thread.currentThread() + e.getMessage() + "," +
                        "等待5秒后重试");
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e2) {
                    LOG.info("休眠500ms");
                }
            }
        }
    }
}
