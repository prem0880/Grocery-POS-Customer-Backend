package com.pos.customer.service;

import org.springframework.http.ResponseEntity;
import com.pos.customer.entity.OAuth;

public interface OAuthService {
	ResponseEntity<String> createCustomerLogin(Long phoneNo, OAuth oauth);

	OAuth getLoginDetails(Long userId);

	ResponseEntity<String> updateLoginCredentials(Long userId, String password);
}
