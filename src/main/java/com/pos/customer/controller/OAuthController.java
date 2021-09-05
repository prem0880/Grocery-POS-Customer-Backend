package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pos.customer.entity.OAuth;
import com.pos.customer.service.OAuthService;

@RestController
@RequestMapping("/login")
public class OAuthController {

	@Autowired
	private OAuthService oauthService;

	@PostMapping("/{phoneNumber}/createLogin")
	public ResponseEntity<String> createCustomerLogin(@PathVariable("phoneNumber") Long phoneNumber,
			@RequestBody OAuth oauth) {
		return oauthService.createCustomerLogin(phoneNumber, oauth);
	}

	@GetMapping("/getLoginCredentials/{userId}")
	public OAuth getLoginDetails(@PathVariable("userId") Long userId) {

		return oauthService.getLoginDetails(userId);

	}

	@PutMapping("/updateLoginCredentials/{userId}/{password}")
	public ResponseEntity<String> updateLoginDetails(@PathVariable("userId") Long userId,
			@PathVariable("password") String password) {
		return oauthService.updateLoginCredentials(userId, password);
	}
}
