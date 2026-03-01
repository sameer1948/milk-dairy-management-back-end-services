package com.milk_dairy_management.controller;

import com.milk_dairy_management.entity.Customer;
import com.milk_dairy_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/test")
    public String test() {
        return "Customer Controller is working!";
    }

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAll() {
        return service.getAllCustomers();
    }

    @PostMapping("/add")
    public Customer save(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }
}