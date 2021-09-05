package com.pos.customer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="OAuth")
public class OAuth implements Serializable {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//private Long loginId;
	private Long userId;
	@NotNull
	@Size(min=8)
	private String password;
	@NotNull
	private String profileStatus;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="phoneNumber",nullable=false)
	@JsonIgnore
	private Customer customer;
	public OAuth(Long userId, @NotNull @Size(min = 8) String password, @NotNull String profileStatus,
			Customer customer) {
		super();
		this.userId = userId;
		this.password = password;
		this.profileStatus = profileStatus;
		this.customer = customer;
	}
	
}
