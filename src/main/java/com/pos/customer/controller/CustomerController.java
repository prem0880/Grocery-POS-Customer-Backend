package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Customer;
import com.pos.customer.repository.CustomerRepository;

@RestController
//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")

public class CustomerController {
	@Autowired
	private CustomerRepository customerrepository;

    
    @PostMapping("/customers")    //validation
    public Customer createCustomer( @RequestBody Customer customer) {
        return customerrepository.save(customer);
    }
   
}