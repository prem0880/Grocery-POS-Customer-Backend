package com.pos.customer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pos.customer.entity.Address;
import com.pos.customer.entity.Country;
import com.pos.customer.entity.Customer;
import com.pos.customer.entity.State;

public interface ProfileService {
	
	ResponseEntity<String> createCustomer(Customer customer);
	ResponseEntity<Customer> getCustomerDetails(Long phoneNo);
	ResponseEntity<String> updateCustomer(Long phoneNo,Customer customerDetails);
	
	ResponseEntity<String> addCountry(Country countryDetails);
	
	ResponseEntity<String> addState(Long countryCode,State stateDetails);
	
	ResponseEntity<String> addAddress(Long customerId,Long stateId,Address addressDetails);
	ResponseEntity<List<Address>> getAddressByCustomerId(Long customerId);
}
