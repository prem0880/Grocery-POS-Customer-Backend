package com.pos.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.customer.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

}
