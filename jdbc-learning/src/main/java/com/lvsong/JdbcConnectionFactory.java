package com.lvsong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lvsong on 12/24/15.
 */
@Service
public class JdbcConnectionFactory implements ConnectionFactory {
    private static final Log LOG = LogFactory.getLog(JdbcConnectionFactory.class);

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init() throws ClassNotFoundException {
        Class.forName(dataSource.getDriver());
    }

    public MyConnection getMyConnection() {
        MyConnection myConnection = new MyConnection();

        try {
            Connection connection = DriverManager.getConnection(
                    dataSource.getUrl(),
                    dataSource.getUserName(),
                    dataSource.getPassword()
            );

            LOG.info("创建数据库连接connection: " + connection + " ，数据库配置如下， url " + dataSource.getUrl() +
                    "，useName: " + dataSource.getUserName() + ", password: " + dataSource.getPassword());

            myConnection.setConnection(connection);
        } catch (SQLException e) {
            LOG.error("获取数据库连接失败，数据库配置如下， url " + dataSource.getUrl() +
            "，useName: " + dataSource.getUserName() + ", password: " + dataSource.getPassword());
            LOG.error(e.getMessage());
        }

        return myConnection;
    }
}
