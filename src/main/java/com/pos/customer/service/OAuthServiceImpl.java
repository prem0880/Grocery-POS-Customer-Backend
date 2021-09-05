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
	
	public ResponseEntity<String> createCustomerLogin(Long phoneNo,OAuth oauth) throws CustomerIdNotFoundException
	{
		return profileRepository.findById(phoneNo).
				map(customer->{
				     oauth.setCustomer(customer);
					 oauthRepository.save(oauth);
                    return new ResponseEntity<String>("Customer Login Details added successfully!", new HttpHeaders(), HttpStatus.OK);
                }).orElseThrow(()->new CustomerIdNotFoundException("Customer Id Not Found,Enter valid Id!"));
	}
	
	public OAuth getLoginDetails(Long userId)
	{
		OAuth customerLoginDetail = oauthRepository.findById(userId).get();
		return customerLoginDetail;
	}
	
	public ResponseEntity<String> updateLoginCredentials(Long userId,String password) throws CustomerIdNotFoundException
	{
	if(!oauthRepository.existsById(userId))
	{
		throw new CustomerIdNotFoundException("Customer Id Not Found,Enter the valid ID!");
	}
	oauthRepository.updateLoginById(userId,password);
	return new ResponseEntity<String>("Customer Login Details Updated Successfully",new HttpHeaders(),HttpStatus.OK);
	}
}
