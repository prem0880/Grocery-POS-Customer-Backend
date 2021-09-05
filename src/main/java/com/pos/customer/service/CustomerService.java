package com.pos.customer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pos.customer.entity.Cart;
import com.pos.customer.entity.CartItem;
import com.pos.customer.exception.CartNotFoundException;

public interface CustomerService {

	ResponseEntity<String> addCart(Long phoneNumber,Cart cart);
	List<Cart> getCart(Long phoneNumber) throws CartNotFoundException;
	 List<Cart> getAllCart();
	 ResponseEntity<String> deleteCart(Long id) throws CartNotFoundException;
	 
	ResponseEntity<String> addItem(Long id,CartItem cartItem);
	 List<CartItem> getAllItem();
	  List<CartItem> getItem(Long id) throws CartNotFoundException;
	 // ResponseEntity<String> deleteItem(Long id) throws CartNotFoundException;
		
		
	
		
	
	
}
