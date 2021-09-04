package com.pos.customer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.customer.entity.Customer;
import com.pos.customer.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerrepository;

	@Override
	public boolean saveCustomer(Customer customer) {
		customerrepository.save(customerrepository);
		return true;
	}
}