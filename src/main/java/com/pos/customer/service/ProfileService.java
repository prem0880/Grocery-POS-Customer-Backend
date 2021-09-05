package com.pos.customer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.pos.customer.entity.Profile;

public interface ProfileService {
	
	ResponseEntity<String> createCustomer(Profile customer);
}
