package com.pos.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Cart;
import com.pos.customer.entity.CartItem;
import com.pos.customer.exception.CartNotFoundException;
import com.pos.customer.service.CustomerService;

@RestController
@RequestMapping("/cart")
public class CustomerController {

	@Autowired
	private CustomerService cartService;
	
	
	@PostMapping("/customer/{phoneNumber}/addCart")
	public ResponseEntity<String> addCart(@PathVariable("phoneNumber") Long phoneNumber,@RequestBody Cart cart)
	{
		return cartService.addCart(phoneNumber,cart);
	}
	
	@PostMapping("/customer/{id}/addItem")
	public ResponseEntity<String> addItem(@PathVariable("id") Long id,@RequestBody CartItem cartItem)
	{
		return cartService.addItem(id,cartItem);
	}
	
	@GetMapping("/customer/getAllCart")
	public List<Cart> getAllCart()
	{
		List<Cart> cart=cartService.getAllCart();
		return cart;
	}
	
	@GetMapping("/customer/{phoneNumber}/getCart")
	public List<Cart> getCart(@PathVariable("phoneNumber") Long phoneNumber) throws CartNotFoundException
	{
		List<Cart> cart=cartService.getCart(phoneNumber);
		return cart;
	}
	
	@GetMapping("/customer/getAllItem")
	public List<CartItem> getAllItem()
	{
		List<CartItem> cart=cartService.getAllItem();
		return cart;
	}
	
	@GetMapping("/customer/{id}/getItem")
	public List<CartItem> getItem(@PathVariable("id") Long id) throws CartNotFoundException
	{
		List<CartItem> cart=cartService.getItem(id);
		return cart;
	}
	
	@DeleteMapping("/customer/{id}/deleteCart")
	public ResponseEntity<String> deleteCart(@PathVariable("id") Long id) throws CartNotFoundException
	{
		return cartService.deleteCart(id);
	}
	
//	@DeleteMapping("/customer/{id}/deleteItem")
//	public ResponseEntity<String> deleteItem(@PathVariable("id") Long id) throws CartNotFoundException
//	{
//		return cartService.deleteItem(id);
//	}
}
