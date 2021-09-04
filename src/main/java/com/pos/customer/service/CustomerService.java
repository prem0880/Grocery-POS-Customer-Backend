package com.pos.customer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.pos.customer.entity.Customer;

public interface CustomerService {
	
	ResponseEntity<String> createCustomer(Customer customer);
}
