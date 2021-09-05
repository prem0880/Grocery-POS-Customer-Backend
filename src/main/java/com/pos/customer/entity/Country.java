package com.pos.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Country")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="country_id")
	private Long id;
	@Column(name="country_code",nullable=false,length=8)
	private Long code;
	@Column(name="country_name",nullable=false)
	@Size(max=10)
	private String name;
	public Country(Long id, Long code, @Size(max = 10) String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
}
