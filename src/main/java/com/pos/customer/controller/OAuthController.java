package com.pos.customer.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<String> createCustomerLogin(@PathVariable("phoneNumber") Long phoneNumber,@RequestBody OAuth oauth) 
	{
		return oauthService.createCustomerLogin(phoneNumber,oauth);
	}
	
	 @GetMapping("/{phoneNumber}/getLoginCredentials")
	 	public ResponseEntity<OAuth> getLoginDetails(@PathVariable("phoneNumber") Long phoneNumber) {
	 		
		return oauthService.getLoginDetails(phoneNumber);	
	 	
	 }
	 @PutMapping("/{phoneNumber}/updateLoginCredentials/{password}")
	 public ResponseEntity<String> updateLoginDetails(@PathVariable("phoneNumber") Long phoneNumber,@PathVariable("password") String password) 
	 {
		 return oauthService.updateLoginCredentials(phoneNumber,password);
	 }
}
