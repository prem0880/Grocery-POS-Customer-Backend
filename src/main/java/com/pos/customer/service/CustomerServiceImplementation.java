package com.pos.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pos.customer.entity.Cart;
import com.pos.customer.entity.CartItem;
import com.pos.customer.entity.Order;
import com.pos.customer.entity.Product;
import com.pos.customer.entity.Wishlist;
import com.pos.customer.entity.WishlistItem;
import com.pos.customer.repository.CartItemRepository;
import com.pos.customer.repository.CartRepository;
import com.pos.customer.repository.CategoryRepository;
import com.pos.customer.repository.CustomerRepository;
import com.pos.customer.repository.OrderRepository;
import com.pos.customer.repository.ProductRepository;
import com.pos.customer.repository.WishlistItemRepository;
import com.pos.customer.repository.WishlistRepository;

public class CustomerServiceImplementation implements CustomerService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private WishlistRepository wishlistRepository;
	@Autowired
	private WishlistItemRepository wishlistItemRepository;
	@Autowired 
	private CategoryRepository categoryRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> getCategoryProducts(Long CategoryId) {
		return categoryRepository.findById(CategoryId).get().getProducts();
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Order placeOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order cancelOrder(Long orderId) {
		Order order=orderRepository.findById(orderId).get();
		order.setStatus("Canceled");
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrders(Long profileId) {
		return customerRepository.findById(profileId).get().getOrders();
	}

	@Override
	public Order getOrder(Long id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public Cart addCartItems(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public CartItem removeCartItem(Long id) {
		CartItem cartItem=cartItemRepository.getById(id);
		cartItemRepository.deleteById(id);
		return cartItem;
	}

	@Override
	public Cart getCart(Long profileId) {
		return customerRepository.findById(profileId).get().getCart();
	}

	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	@Override
	public Order getRecipt(Long orderId) {
		return orderRepository.getById(orderId);
	}

	@Override
	public WishlistItem addWishlistItem(WishlistItem wishlistItem) {
		return wishlistItemRepository.save(wishlistItem);
	}

	@Override
	public WishlistItem removeWishlistItem(Long id) {
		WishlistItem wishlistItem=wishlistItemRepository.getById(id);
		wishlistRepository.deleteById(id);
		return wishlistItem;
	}

	@Override
	public Wishlist getWishlist(Long profileId) {
		return customerRepository.getById(profileId).getWishlist();
	}

}
