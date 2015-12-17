package com.lvsong.customer.dao;

import com.lvsong.customer.model.Customer;

/**
 * Created by lvsong on 7/20/15.
 */
public interface CustomerDAO {
    public void insert(Customer customer);
    public Customer findByCustomerId(int id);
}
