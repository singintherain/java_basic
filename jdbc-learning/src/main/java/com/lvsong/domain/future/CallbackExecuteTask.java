package com.lvsong.domain.future;

import com.lvsong.ConnectionPool;
import com.lvsong.MyConnection;
import com.lvsong.NoIdleConnectionException;
import com.lvsong.TaskBodyIntef;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;

/**
 * Created by lvsong on 2/21/16.
 */
public class CallbackExecuteTask implements Runnable {
    private static final Log LOG = LogFactory.getLog(CallbackExecuteTask.class);

    private ConnectionPool connectionPool;
    private TaskBodyIntef taskBody;

    public CallbackExecuteTask(ConnectionPool connectionPool, TaskBodyIntef taskBody) {
        this.connectionPool = connectionPool;
        this.taskBody = taskBody;
    }

    public void run() {
        while(true) {
            try {
                MyConnection myConnection = connectionPool.getConnection();

                taskBody.start(myConnection);

                myConnection.free();
                break;
            } catch (NoIdleConnectionException e) {
                LOG.error("任务" + Thread.currentThread() + e.getMessage() + "," +
                        "等待5秒后重试");
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e2) {
                    LOG.info("休眠500ms");
                }
            } catch (Exception e) {
                LOG.error(e.getMessage());
                break;
            }
        }
    }
}
