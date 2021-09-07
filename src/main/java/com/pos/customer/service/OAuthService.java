package com.pos.customer.service;

import com.pos.customer.entity.Customer;


public interface OAuthService {
	Customer login(Long userId, String password);
	Customer register(Customer customer);
	//boolean authorize(String token);
}
