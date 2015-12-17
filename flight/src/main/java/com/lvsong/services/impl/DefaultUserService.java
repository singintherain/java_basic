package com.lvsong.services.impl;

import com.lvsong.dao.UserDAO;
import com.lvsong.models.User;
import com.lvsong.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by lvsong on 7/20/15.
 */
@Service
public class DefaultUserService implements UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> findAll() {
        System.out.println("find all");
        return null;
    }

    public void saveOrUpdate(User user) {
        System.out.println("save or update");

    }

    public User findById(int id) {
        System.out.println("find by id");
        return null;
    }

    public boolean delete(int id) {
        System.out.println("delete");
        return false;
    }
}
