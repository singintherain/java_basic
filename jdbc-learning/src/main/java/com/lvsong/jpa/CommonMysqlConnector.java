package com.lvsong.jpa;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by lvsong on 8/30/15.
 */
public class CommonMysqlConnector {
    private String driver;
    private String url;
    private String username;
    private String password;
    private HikariConfig config;
    private DataSource dataSource;

    public CommonMysqlConnector(String mysqlConf) {
        loadConfig(mysqlConf);
        initConfig(mysqlConf);
        initDataSource();

    }

    private void loadConfig(String mysqlConf) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(mysqlConf));

            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
        } catch (IOException e) {
            throw new RuntimeException("数据库配置文件不存在: " + mysqlConf);
        }
    }

    private void initConfig(String configFilePath){
        config = new HikariConfig();

        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

    }

    private void initDataSource() {
        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() {
        try {
            Connection connection = dataSource.getConnection();

            return connection;
        } catch (SQLException e) {
            System.out.println("数据库连接错误:" + e.getMessage());

            throw new RuntimeException(e);
        }
    }
}
