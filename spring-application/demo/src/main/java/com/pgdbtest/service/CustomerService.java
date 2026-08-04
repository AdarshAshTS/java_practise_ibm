package com.pgdbtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgdbtest.entity.Customer;
import com.pgdbtest.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}