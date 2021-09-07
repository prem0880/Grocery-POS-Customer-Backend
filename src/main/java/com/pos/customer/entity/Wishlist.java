package com.pos.customer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="wishlists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wishlist {
	@Id @GeneratedValue @Column(name="wishlist_id")
	private Long id;
	
	@OneToOne @JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy="wishlist")
	private List<WishlistItem> wishlistItems;
}
