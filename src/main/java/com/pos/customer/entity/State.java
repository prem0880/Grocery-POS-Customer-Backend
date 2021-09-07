package com.pos.customer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "states")
public class State{
	@Id @GeneratedValue @Column(name = "state_id")
	private Long id;
	
	@Column(name = "state_name")
	private String name;
	
	@ManyToOne @JoinColumn(name = "country_id") @JsonIgnore
	private Country country;
	
	@OneToMany(mappedBy="state") @JsonIgnore
	private List<Address> addresses;
}
