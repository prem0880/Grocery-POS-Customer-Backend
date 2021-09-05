package com.pos.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="cartItem")
public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long autoId;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private Cart cartId; 
	
	@Column(nullable=false)
	private String productId;
	@Column(nullable=false)
	private Integer quantity;
	@Column(nullable=false)
	private Double price;
	
	
}
