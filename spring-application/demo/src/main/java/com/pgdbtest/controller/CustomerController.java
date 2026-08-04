package com.pgdbtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pgdbtest.entity.Customer;
import com.pgdbtest.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @GetMapping("/all")
    public List<Customer> getCustomers() {
        return service.getAllCustomers();
    }
}