package com.lvsong.dao.impl;

import com.lvsong.dao.UserDAO;
import com.lvsong.models.User;
import org.springframework.stereotype.Repository;

/**
 * Created by lvsong on 7/20/15.
 */
@Repository
public class DefaultUserDAO implements UserDAO {
    public void save(User user) {
        System.out.println("save user");
    }
}
