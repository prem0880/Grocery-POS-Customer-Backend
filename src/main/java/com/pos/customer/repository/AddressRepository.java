package com.pos.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pos.customer.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{
	@Query("SELECT a FROM Address a WHERE a.customer.phoneNumber=:customerId")
	List<Address> getByCustomerId(@Param("customerId") Long customerId);

}
