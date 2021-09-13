package com.pos.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.pos.customer.entity.OAuth;
import com.pos.customer.repository.CustomerRepository;
import com.pos.customer.repository.OAuthRepository;

@Service
public class OAuthServiceImpl implements OAuthService {

	@Autowired
	private CustomerRepository profileRepository;
	@Autowired
	private OAuthRepository oauthRepository;

	public ResponseEntity<String> createCustomerLogin(Long phoneNo, OAuth oauth) {
		return profileRepository.findById(phoneNo).map(customer -> {
			oauth.setCustomer(customer);
			oauthRepository.save(oauth);
			return new ResponseEntity<String>("Customer Login Details added successfully!", new HttpHeaders(),
					HttpStatus.OK);
		}).orElse(new ResponseEntity<String>("Customer Not Found With" + " " + phoneNo + "!", new HttpHeaders(),
				HttpStatus.OK));
	}

	public OAuth getLoginDetails(Long userId) {
		OAuth customerLoginDetail = oauthRepository.findById(userId).get();
		return customerLoginDetail;
	}

	public ResponseEntity<String> updateLoginCredentials(Long userId, String password) {
		ResponseEntity<String> response=null;
		if (!oauthRepository.existsById(userId)) {
			response=new ResponseEntity<String>("Customer Not Found With" + " " + userId + "!", new HttpHeaders(),
					HttpStatus.OK);
		}
		oauthRepository.updateLoginById(userId, password);
		response=new ResponseEntity<String>("Customer Login Details Updated Successfully", new HttpHeaders(),
				HttpStatus.OK);
		return response;
	}
}
