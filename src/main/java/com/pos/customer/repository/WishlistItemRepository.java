package com.pos.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.customer.entity.WishlistItem;

public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {

}
