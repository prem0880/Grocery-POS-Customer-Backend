package com.pos.customer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
public class Category {
	@Id @GeneratedValue @Column(name="category_id",nullable=false)
	private Long id;
	
	@Column(name="category_name",nullable=false)
	private String name;
	
	@OneToMany(mappedBy="product")
	private List<Product> products;
}
