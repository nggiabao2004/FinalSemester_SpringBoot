package com.gdu_springboot.springboot_demo.service;

import com.gdu_springboot.springboot_demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    Customer save(Customer customer);
    void deleteById(int id);
}
