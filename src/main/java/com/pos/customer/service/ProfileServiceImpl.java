package com.pos.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.customer.entity.Address;
import com.pos.customer.entity.Country;
import com.pos.customer.entity.Customer;
import com.pos.customer.entity.State;
import com.pos.customer.repository.AddressRepository;
import com.pos.customer.repository.CountryRepository;
import com.pos.customer.repository.CustomerRepository;
import com.pos.customer.repository.OAuthRepository;
import com.pos.customer.repository.StateRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OAuthRepository oAuthRepository;

	@Override
	public ResponseEntity<String> createCustomer(Customer customer) {
		customerRepository.save(customer);
		return new ResponseEntity<String>("Customer profile is created", new HttpHeaders(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> addCountry(Country countryDetails) {
		// TODO Auto-generated method stub
		countryRepository.save(countryDetails);
		return new ResponseEntity<String>("Country Details Added Successfully!", new HttpHeaders(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> addState(Long countryCode, State stateDetails) {
		// TODO Auto-generated method stub
		return countryRepository.findById(countryCode).map(country -> {
			stateDetails.setCountry(country);
			stateRepository.save(stateDetails);
			return new ResponseEntity<String>("State Details Added Successfully!", new HttpHeaders(), HttpStatus.OK);
		}).orElse(new ResponseEntity<String>("Country Not Found With" + " " + countryCode + "!", new HttpHeaders(),
				HttpStatus.OK));
	}

	@Override
	public ResponseEntity<Customer> getCustomerDetails(Long phoneNo) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Customer>(customerRepository.findById(phoneNo).get(), new HttpHeaders(),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateCustomer(Long phoneNo, Customer customerDetails) {
		// TODO Auto-generated method stub
		return customerRepository.findById(phoneNo).map(customer -> {
			customer.setName(customerDetails.getName());
			customer.setEmail(customerDetails.getEmail());
			customerRepository.save(customer);
			return new ResponseEntity<String>("Customer Details Updated Successfully!", new HttpHeaders(),
					HttpStatus.OK);
		}).orElse(new ResponseEntity<String>("Customer Not Found With" + " " + phoneNo + "!", new HttpHeaders(),
				HttpStatus.OK));
	}

	@Override
	public ResponseEntity<String> addAddress(Long customerId, Long stateId, Address addressDetails) {
		// TODO Auto-generated method stub
		ResponseEntity<String> response = null;
		if (!customerRepository.existsById(customerId)) {
			response = new ResponseEntity<String>("Customer Not Found With" + " " + customerId + "!", new HttpHeaders(),
					HttpStatus.OK);
		}
		if (!stateRepository.existsById(stateId)) {
			response = new ResponseEntity<String>("State Not Found With" + " " + stateId + "!", new HttpHeaders(),
					HttpStatus.OK);
		}
		Customer customer = customerRepository.findById(customerId).get();
		addressDetails.setCustomer(customer);
		State state = stateRepository.findById(stateId).get();
		addressDetails.setState(state);
		addressRepository.save(addressDetails);
		response = new ResponseEntity<String>("Address Details Added Successfully!", new HttpHeaders(), HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<List<Address>> getAddressByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		List<Address> addressList = addressRepository.getByCustomerId(customerId);
		return new ResponseEntity<List<Address>>(addressList, new HttpHeaders(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> activateProfile(Long phoneNo, String status) {
		// TODO Auto-generated method stub
		ResponseEntity<String> response = null;
		if (!oAuthRepository.existsById(phoneNo)) {
			response = new ResponseEntity<String>("Customer Not Found With" + " " + phoneNo + "!", new HttpHeaders(),
					HttpStatus.OK);
		}
		oAuthRepository.activateProfile(phoneNo, status);
		response = new ResponseEntity<String>("Profile Activated Successfully!", new HttpHeaders(), HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<String> deActivateProfile(Long phoneNo, String status) {
		// TODO Auto-generated method stub
		ResponseEntity<String> response = null;
		if (!oAuthRepository.existsById(phoneNo)) {
			response = new ResponseEntity<String>("Customer Not Found With" + " " + phoneNo + "!", new HttpHeaders(),
					HttpStatus.OK);
		}
		oAuthRepository.deActivateProfile(phoneNo, status);
		response = new ResponseEntity<String>("Profile Deactivated Successfully!", new HttpHeaders(), HttpStatus.OK);
		return response;
	}
}