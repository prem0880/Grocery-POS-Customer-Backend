package com.pos.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.customer.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
