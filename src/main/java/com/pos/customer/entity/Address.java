package com.pos.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address{
	@Id @GeneratedValue @Column(name="address_id")
	private Long id;
	
	@Column(name = "address_line", nullable = false)
	private String addressLine;
	
	@Column(name = "address_city", nullable = false)
	private String city;
	
	@Column(name = "address_pincode", nullable = false, length = 6)
	private Long pinCode;
	
	@ManyToOne @JoinColumn(name = "state_id", nullable = false)
	private State state;
	
	@ManyToOne @JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
}
