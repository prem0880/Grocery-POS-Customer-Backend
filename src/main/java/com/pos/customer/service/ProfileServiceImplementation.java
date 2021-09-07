package com.pos.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.customer.entity.Address;
import com.pos.customer.entity.Customer;
import com.pos.customer.entity.OAuth;
import com.pos.customer.repository.AddressRepository;
import com.pos.customer.repository.CustomerRepository;
import com.pos.customer.repository.OAuthRepository;

@Service
public class ProfileServiceImplementation implements ProfileService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OAuthRepository oauthRepository;
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Customer getProfile(Long customerId) {
		return customerRepository.getById(customerId);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public OAuth activateProfile(OAuth oauth) {
		return oauthRepository.save(oauth);
	}

	@Override
	public OAuth deactivateAccount(OAuth oauth) {
		return oauthRepository.save(oauth);
	}

	@Override
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address deleteAddress(Long id) {
		Address address=addressRepository.getById(id);
		addressRepository.deleteById(id);
		return address;
	}

	@Override
	public Address getAddress(Long id) {
		return addressRepository.getById(id);
	}

	@Override
	public List<Address> getAddresses(Long profileId) {
		return customerRepository.getById(profileId).getAddresses();
	}
	
}
