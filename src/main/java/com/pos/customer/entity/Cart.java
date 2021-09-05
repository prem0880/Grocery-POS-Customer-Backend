package com.pos.customer.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="cartId")
	private Set<CartItem> cartItems;
	
	@Column(nullable=false)
	private Double totalPrice;
	@Column(nullable=false)
	private Long customerId;
	@Column(nullable=false)
	private String status;
}
