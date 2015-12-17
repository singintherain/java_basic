package com.lvsong.hello;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by lvsong on 8/5/15.
 */
public interface CustomerRespository extends MongoRepository<Customer, String>{
    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
