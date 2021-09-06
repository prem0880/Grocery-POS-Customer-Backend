package com.pos.customer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "address_line", nullable = false)
	private String addressLine;
	@Column(name = "address_city", nullable = false)
	private String city;
	@Column(name = "address_pincode", nullable = false, length = 6)
	private Long pinCode;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "state_id", nullable = false)
	@JsonIgnore
	private State state;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonIgnore
	private Customer customer;
}
