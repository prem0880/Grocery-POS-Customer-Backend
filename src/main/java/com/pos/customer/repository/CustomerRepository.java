package com.pos.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
