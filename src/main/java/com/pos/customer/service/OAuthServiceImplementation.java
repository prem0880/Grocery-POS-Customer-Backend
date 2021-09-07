package com.pos.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.customer.entity.Cart;
import com.pos.customer.entity.Customer;
import com.pos.customer.entity.OAuth;
import com.pos.customer.entity.Wishlist;
import com.pos.customer.repository.CustomerRepository;
import com.pos.customer.repository.OAuthRepository;

@Service
public class OAuthServiceImplementation implements OAuthService{
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OAuthRepository oauthRepository;

	@Override
	public Customer login(Long userId, String password) {
		OAuth oauth=oauthRepository.existsById(userId)?oauthRepository.getById(userId):null;
		if(oauth!=null & oauth.getPassword().equals(password))
			return oauth.getCustomer();
		return null;
	}

	@Override
	public Customer register(Customer customer) {
		customer.setCart(new Cart());
		customer.setWishlist(new Wishlist());
		return customerRepository.save(customer);
	}
}