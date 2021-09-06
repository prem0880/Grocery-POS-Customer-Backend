package com.pos.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {
	@Id @GeneratedValue @Column(name="order_item_id")
	private Integer id;
	@Column(name="order_item_quantity")
	private Integer quantity;
	@Column(name="order_item_price")
	private Double price;
	@ManyToOne
	private Order order;
	@ManyToOne
	private Product product;
}
*/