package com.pos.customer.service;

import java.util.List;

import com.pos.customer.entity.Cart;
import com.pos.customer.entity.CartItem;
import com.pos.customer.entity.Order;
import com.pos.customer.entity.Product;
import com.pos.customer.entity.Wishlist;
import com.pos.customer.entity.WishlistItem;

public interface CustomerService {
	List<Product> getProducts();
	List<Product> getCategoryProducts(Long categoryId);
	Product getProduct(Long id);
	Order placeOrder(Order order);
	Order cancelOrder(Long orderId);
	List<Order> getOrders(Long profileId);
	Order getOrder(Long id);
	Cart addCartItems(Cart cart);
	CartItem removeCartItem(Long id);
	Cart getCart(Long profileId);
	CartItem updateCartItem(CartItem cartItem);
	Order getRecipt(Long orderId);
	WishlistItem addWishlistItem(WishlistItem wishlistItem);
	WishlistItem removeWishlistItem(Long id);
	Wishlist getWishlist(Long profileId);
}
