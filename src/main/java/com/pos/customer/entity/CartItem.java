package com.pos.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart_items")
public class CartItem {
	@Id @GeneratedValue @Column(name="cart_item_id")
	private Long id;
	
	@Column(nullable=false)
	private Integer quantity;
	
	@Column(nullable=false)
	private Double price;
	
	@ManyToOne @JoinColumn(name="cart_id", nullable=false) @JsonIgnore
	private Cart cart; 
	
	@ManyToOne @JoinColumn(name="product_id",nullable=false) @JsonIgnore
	private Product product;
}
