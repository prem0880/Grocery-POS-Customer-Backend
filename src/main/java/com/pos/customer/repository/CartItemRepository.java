package com.pos.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.customer.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long>{
	
}
