package com.pos.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="oauths")
public class OAuth{
	@Id @GeneratedValue @Column(name="oauth_id")
	private Long id;
	
	@OneToOne @JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(name="oauth_password") @Size(min=8)
	private String password;
	
	@Column(name="oauth_profile_status")
	private String profileStatus;
}
