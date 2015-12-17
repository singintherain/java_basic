package com.lvsong.services;

import com.lvsong.models.User;

import java.util.List;

/**
 * Created by lvsong on 7/17/15.
 */
public interface UserService {
    public List<User> findAll();
    public void saveOrUpdate(User user);
    public User findById(int id);
    public boolean delete(int id);
}
