package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Customer;
import com.pos.customer.repository.ProfileRepository;
import com.pos.customer.service.ProfileService;

@RestController
@RequestMapping("/profile")

public class ProfileController {
	@Autowired
	private ProfileService customerService;

    
    @PostMapping("/createProfile") 
    public ResponseEntity<String> createCustomer( @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
   
}