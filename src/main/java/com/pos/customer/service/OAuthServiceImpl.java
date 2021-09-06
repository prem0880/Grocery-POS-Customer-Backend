package com.pos.customer.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.pos.customer.entity.OAuth;
import com.pos.customer.exception.CustomerIdNotFoundException;
import com.pos.customer.repository.OAuthRepository;
import com.pos.customer.repository.ProfileRepository;

@Service
public class OAuthServiceImpl implements OAuthService{

	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private OAuthRepository oauthRepository;
	
	public ResponseEntity<String> createCustomerLogin(Long phoneNo,OAuth oauth) 
	{
		return profileRepository.findById(phoneNo).
				map(customer->{
				     oauth.setCustomer(customer);
					 oauthRepository.save(oauth);
                    return new ResponseEntity<String>("Customer Login Details added successfully!", new HttpHeaders(), HttpStatus.OK);
                }).orElse(new ResponseEntity<String>("Customer Not Found With" + " " + phoneNo + "!", new HttpHeaders(),
        				HttpStatus.OK));
	}
	
	public ResponseEntity<OAuth> getLoginDetails(Long phoneNo) 
	{
		
		OAuth authDetail= oauthRepository.findByPhoneNumber(phoneNo);
		return new ResponseEntity<OAuth>(authDetail,new HttpHeaders(),HttpStatus.OK);
	}
	
	public ResponseEntity<String> updateLoginCredentials(Long phoneNo,String password) 
	{
	oauthRepository.updateLoginById(phoneNo,password);
	return new ResponseEntity<String>("Customer Login Details Updated Successfully",new HttpHeaders(),HttpStatus.OK);
	}
}
