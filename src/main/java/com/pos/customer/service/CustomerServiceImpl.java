package com.pos.customer.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.pos.customer.entity.Cart;
import com.pos.customer.entity.CartItem;
import com.pos.customer.entity.Customer;
import com.pos.customer.exception.CartNotFoundException;
import com.pos.customer.exception.ProductIdNotFoundException;
import com.pos.customer.repository.CartItemRepository;
import com.pos.customer.repository.CartRepository;
import com.pos.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private CustomerRepository profileRepository;
	@Override
	public ResponseEntity<String> addCart(Long phoneNumber,Cart cart) {
	
		cart.setTotalPrice(0.00);
		cart.setStatus("Created");
		Customer cust=new Customer();
		cust.setPhoneNumber(phoneNumber);
		cart.setUserId(cust);
		
		cartRepository.save(cart);
		return new ResponseEntity<String>("Cart is created Successfully",new HttpHeaders(),HttpStatus.OK);
	}
	@Override
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}
	
	@Override
	public List<Cart> getCart(Long phoneNumber) throws CartNotFoundException {
		
		if(!profileRepository.existsById(phoneNumber))
		{
			throw new CartNotFoundException("PhnNumber Not Found,Enter the valid ID!");
		}
		List<Cart> cart=cartRepository.findByphnNo(phoneNumber);
		return cart;		
	}
	
	@Override
	public ResponseEntity<String> deleteCart(Long id) throws CartNotFoundException {
		return cartRepository.findById(id)
				.map(cart->{
					cartRepository.delete(cart);
					return new ResponseEntity<String>("Cart Details Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
				}).orElseThrow(()->new CartNotFoundException("Cart Not Found,Enter the valid ID!"));

	}
	@Override
	public ResponseEntity<String> addItem(Long id, CartItem cartItem) {
		
		Cart cart=new Cart();
		cart.setId(id);
		cartItem.setCartId(cart);
		
//		double sum=0.0;
//		sum=sum+cartItem.getPrice();
//		cart.setTotalPrice(sum);
		
		
		cartItemRepository.save(cartItem);
		return new ResponseEntity<String>("Cart is created Successfully",new HttpHeaders(),HttpStatus.OK);
	
	}
	@Override
	public List<CartItem> getAllItem() {
		return cartItemRepository.findAll();
	}
	@Override
	public List<CartItem> getItem(Long id) throws CartNotFoundException {
		if(!cartRepository.existsById(id))
		{
			throw new CartNotFoundException("CartId Not Found,Enter the valid ID!");
		}
		List<CartItem> cart=cartItemRepository.findByCartId(id);
		return cart;
	}
//	@Override
//	public ResponseEntity<String> deleteItem(Long id) throws CartNotFoundException {
//		return cartRepository.findById(id)
//				.map(cart->{
//					cartItemRepository.deleteById(id);
//					return new ResponseEntity<String>("Cart Details Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
//				}).orElseThrow(()->new CartNotFoundException("Cart Not Found,Enter the valid ID!"));
//
//	}
	

	public ResponseEntity<String> updateItem(Long id,String productId, Integer quantity, Double price) throws  ProductIdNotFoundException {
		
			if(cartItemRepository.findProductId(productId)==null)
				throw new ProductIdNotFoundException("ProductId not found");
			else {	
			cartItemRepository.update(productId,quantity,price);
			return new ResponseEntity<String>("Item Details Updated Successfully!", new HttpHeaders(),HttpStatus.OK);
		}
	}
	@Override
	public ResponseEntity<String> deleteItem( Long id,String productId) throws ProductIdNotFoundException {
		
		if(cartItemRepository.findProductId(productId)==null)
			throw new ProductIdNotFoundException("ProductId not found");
		else {	
		cartItemRepository.deleteProduct(productId);
		return new ResponseEntity<String>("Item Deleted Successfully!", new HttpHeaders(),HttpStatus.OK);
	}
	}
	


}
