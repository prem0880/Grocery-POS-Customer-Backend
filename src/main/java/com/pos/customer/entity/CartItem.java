package com.pos.customer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="cartItem")
public class CartItem implements Serializable {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long autoId;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	@JsonIgnore
	private Cart cartId; 
	
	@Column(nullable=false)
	private String productId;
	@Column(nullable=false)
	private Integer quantity;
	@Column(nullable=false)
	private Double price;
	public CartItem(Long autoId, Cart cartId, String productId, Integer quantity, Double price) {
		super();
		this.autoId = autoId;
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	
	
}
