package com.pos.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pos.customer.entity.Cart;
import com.pos.customer.entity.CartItem;
@Repository
@Transactional
public interface CartItemRepository extends JpaRepository<CartItem,Long>{

	@Query("select c from CartItem c where c.cartId.id=:id")
	List<CartItem> findByCartId(@Param("id") Long id);
	
//	@Query("select c from CartItem c where c.cartId.id=:id=:id")
//	void deleteById(@Param("id") Long id);
}
