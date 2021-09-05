package com.pos.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@Column(length=10)
	private Long phoneNumber;
	@NotNull
	@Size(max=20)
	private String name;
	@NotNull
	@Email
	private String email;
	@OneToOne(fetch=FetchType.LAZY,mappedBy="customer")
	private OAuth oauth;
	public Customer(Long phoneNumber, String name, String email) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
	}
	
}
