package com.pos.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.customer.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
