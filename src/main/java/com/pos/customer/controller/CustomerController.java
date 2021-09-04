package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Customer;
import com.pos.customer.repository.CustomerRepository;
import com.pos.customer.service.CustomerService;

@RestController
@RequestMapping("/profile")

public class CustomerController {
	@Autowired
	private CustomerService customerService;

    
    @PostMapping("/createProfile") 
    public ResponseEntity<String> createCustomer( @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
   
}