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

@Entity
@Table(name="wishlist_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishlistItem {
	@Id @GeneratedValue @Column(name="wishlist_item_id")
	private Long id;
	
	@ManyToOne @JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne @JoinColumn(name="wishlist_id") @JsonIgnore
	private Wishlist wishlist;
}
