package com.pos.customer.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="cart")
public class Cart implements Serializable{

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="cartId")
	private Set<CartItem> cartItems;
	
	@OneToOne
	@JoinColumn(name="phoneNumber",nullable=false,unique=true)
	@JsonIgnore
	  private Profile userId;
	
	@Column(nullable=false)
	private Double totalPrice;
	
	@Column(nullable=false)
	private String status;

	public Cart(Long id, Set<CartItem> cartItems, Profile userId, Double totalPrice, String status) {
		super();
		this.id = id;
		this.cartItems = cartItems;
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.status = status;
	}
	
	
}
