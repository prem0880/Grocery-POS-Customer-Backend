package com.pos.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Cart;
import com.pos.customer.entity.CartItem;
import com.pos.customer.entity.Order;
import com.pos.customer.entity.Product;
import com.pos.customer.entity.Wishlist;
import com.pos.customer.entity.WishlistItem;
import com.pos.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return customerService.getProducts();
	}
	
	@GetMapping("/products/{category-id}")
	public List<Product> getCategoryProducts(@PathVariable("category-id")Long categoryId){
		return customerService.getCategoryProducts(categoryId);
	}
	
	@GetMapping("/product/{product-id}")
	public Product getProduct(@PathVariable("product-id")Long id) {
		return customerService.getProduct(id);
	}
	
	@PostMapping("/place-order")
	public Order placeOrder(@RequestBody Order order) {
		return customerService.placeOrder(order);
	}
	
	@PutMapping("/cancel-order")
	public Order cancelOrder(@RequestParam("order-id") Long orderId) {
		return customerService.cancelOrder(orderId);
	}
	
	@GetMapping("/orders")
	public List<Order> getOrders(@RequestParam("customer-id") Long profileId){
		return customerService.getOrders(profileId);
	}
	
	@GetMapping("/order")
	public Order getOrder(@RequestParam("order-id") Long id) {
		return customerService.getOrder(id);
	}
	
	@PostMapping("/add-cart-item")
	public Cart addCartItems(@RequestBody Cart cart) {
		return customerService.addCartItems(cart);
	}
	
	@DeleteMapping("/delete-cart-item")
	public CartItem removeCartItem(@RequestParam("cart-item-id") Long id) {
		return customerService.removeCartItem(id);
	}
	
	@GetMapping("/cart")
	public Cart getCart(@RequestParam("profile-id") Long profileId) {
		return customerService.getCart(profileId);
	}
	
	@PutMapping("/update-cart-item")
	public CartItem updateCartItem(@RequestBody CartItem cartItem) {
		return customerService.updateCartItem(cartItem);
	}
	
	@GetMapping("/recipt")
	public Order getRecipt(@RequestParam("order-id") Long orderId) {
		return customerService.getRecipt(orderId);
	}
	
	@PostMapping("/add-wishlist-item")
	public WishlistItem addWishlistItem(@RequestBody WishlistItem wishlistItem) {
		return customerService.addWishlistItem(wishlistItem);
	}
	
	@DeleteMapping("/delete-wishlist-item")
	public WishlistItem removeWishlistItem(@RequestParam("wishlist-item-id") Long id) {
		return customerService.removeWishlistItem(id);
	}
	
	@GetMapping("/get-wishlist")
	public Wishlist getWishlist(@RequestParam("profile-id") Long profileId) {
		return customerService.getWishlist(profileId);
	}
}
