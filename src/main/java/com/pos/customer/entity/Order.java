package com.pos.customer.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private Integer id;
	@Column(name="order_date")
	private LocalDate date;
	@Column(name="order_total_price")
	private Double totalPrice;
	@Column(name="order_discount")
	private Float discount;
	@Column(name="order_payment_mode")
	private String modeOfPayment;
	@Column(name="order_status")
	private String status;
	@Column(name="order_tracking")
	private String tracking;
	@ManyToOne
	private Address address;
	@ManyToOne
	private Customer customer;
}

