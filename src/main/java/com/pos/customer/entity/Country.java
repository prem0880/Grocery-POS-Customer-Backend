package com.pos.customer.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Country")
public class Country implements Serializable{
	@Id
	@Column(name="country_code",length=8)
	private Long code;
	@Column(name="country_name",nullable=false)
	private String name;
	@OneToMany(mappedBy="country",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<State> states;
	public Country(Long code, @Size(max = 10) String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
}
