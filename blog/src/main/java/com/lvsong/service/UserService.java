package com.lvsong.service;

import com.lvsong.dao.UserDao;
import com.lvsong.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lvsong on 7/21/15.
 */
public class UserService {
    @Autowired
    private UserDao userDao;

    public void register(User user) {

    }

    public void login(User user) {

    }

    public void logout() {

    }
}
