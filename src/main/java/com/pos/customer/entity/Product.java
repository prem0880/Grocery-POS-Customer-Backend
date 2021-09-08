package com.pos.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString
@NoArgsConstructor
@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id",nullable=false)
	private Long productid;
	
	@Column(name="product_name",nullable=false)
	private String productname;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="product_description",nullable=false)
	private String description;
	
	@Column(name="product_MRP",nullable=false)
	private Double mrp;
	
	@Column(name="product_brand",nullable=false)
	private String brand;
	
	@Column(name="product_stock",nullable=false)
	private Long stock;
	
	@Column(name="product_tax",nullable=false)
	private Double tax;
	
	@ManyToOne
	private Category category;
	
}
