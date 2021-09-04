package com.pos.customer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pos.customer.entity.Customer;
import com.pos.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<String> createCustomer( Customer customer) {
		 customerRepository.save(customer);
		 return new ResponseEntity<String>("Customer profile is created",new HttpHeaders(),HttpStatus.OK);
	}
}