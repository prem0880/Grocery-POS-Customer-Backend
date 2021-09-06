package com.pos.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id",nullable=false)
	private Long categoryid;
	
	@Column(name="category_name",nullable=false)
	private String categoryname;
	
}
