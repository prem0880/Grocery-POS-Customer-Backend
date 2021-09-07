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
@Table(name="products")
public class Product {
	@Id @GeneratedValue @Column(name="product_id")
	private Long id;
	
	@Column(name="product_name",nullable=false)
	private String name;
	
	@Column(name="image_url",nullable=false)
	private String imageUrl;
	
	@Column(name="product_description",nullable=false)
	private String description;
	
	@Column(name="product_mrp",nullable=false)
	private Double mrp;
	
	@Column(name="product_brand",nullable=false)
	private String brand;
	
	@Column(name="product_stock",nullable=false)
	private Long stock;
	
	@Column(name="product_tax",nullable=false)
	private Double tax;
	
	@ManyToOne @JoinColumn(name="category_id")
	private Category category;
	
}
