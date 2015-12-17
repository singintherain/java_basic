package com.lvsong.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by lvsong on 7/21/15.
 */
@Repository
public abstract class BaseMysqlDao<T> {
    @Autowired
    private DataSource dataSource;

    public abstract void create(T t);
    public abstract void destroy(T t);
    public abstract T findById(int id);
    public abstract void update(T t);

    protected DataSource getDataSource() {
        return dataSource;
    }
}
