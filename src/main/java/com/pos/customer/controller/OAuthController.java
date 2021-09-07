package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Customer;
import com.pos.customer.entity.OAuth;
import com.pos.customer.service.OAuthService;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

	@Autowired 
	private OAuthService oauthService;
	
	@PostMapping("/login")
	public Customer login(@RequestBody OAuth oauth) {
		return oauthService.login(oauth.getId(),oauth.getPassword());
	}
	
	@PostMapping("/register")
	public Customer register(@RequestBody Customer customer) {
		return oauthService.register(customer);
	}
}
