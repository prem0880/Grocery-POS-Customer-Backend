package com.pos.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	
	@Modifying
	@Query("update CartItem c set c.quantity=:quantity,c.price=:price where c.productId=:productId")
	void update(@Param("productId") String productId, @Param("quantity") Integer quantity, @Param("price") Double price);

	
	@Query("select c from CartItem c where c.productId=:productId ")
	CartItem findProductId(@Param("productId") String productId);

	@Modifying
	@Query("delete from CartItem  where productId=:productId")
	void deleteProduct(@Param("productId") String productId);
	
//	@Query("select c from CartItem c where c.cartId.id=:id=:id")
//	void deleteById(@Param("id") Long id);
	
	
}
