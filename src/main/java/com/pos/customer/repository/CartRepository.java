package com.pos.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.pos.customer.entity.Cart;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart,Long>{

	@Query("select c from Cart c where c.userId.phoneNumber=:phnNo")
	List<Cart> findByphnNo(@Param("phnNo") Long phoneNumber);
}
