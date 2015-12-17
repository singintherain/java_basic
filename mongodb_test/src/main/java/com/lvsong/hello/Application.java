package com.lvsong.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by lvsong on 8/5/15.
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private CustomerRespository customerRespository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerRespository.deleteAll();

        customerRespository.save(new Customer("Alice", "Smith"));
        customerRespository.save(new Customer("Bob", "Smith"));

        System.out.println("Customers found with foundAll():");
        System.out.println("-------------------------------");

        for(Customer customer : customerRespository.findAll()){
            System.out.println(customer);
        }

        System.out.println();

        System.out.println("Customer found with findByFirstName('Alice')");
        System.out.println("---------------------------------------");
        System.out.println(customerRespository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith')");
        System.out.println("---------------------------------------");
        for(Customer customer : customerRespository.findByLastName("Smith")) {
            System.out.println(customer);
        }
    }
}
