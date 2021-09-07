package com.pos.customer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
	@Id @Column(name="customer_id")
	private Long phoneNumber;
	
	@Column(name="customer_name")
	private String name;
	
	@Column(name="customer_email")
	private String email;
	
	@OneToOne(mappedBy = "customer")
	private OAuth oauth;
	
	@OneToOne(mappedBy="customer")
	private Wishlist wishlist;
	
	@OneToOne(mappedBy="customer")
	private Cart cart;
	
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses;
	
	@OneToMany(mappedBy="customer")
	private List<Order> orders;
}
