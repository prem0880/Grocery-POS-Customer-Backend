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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "State")
public class State implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	private Long id;
	@Column(name = "state_name")
	private String name;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "country_code", nullable = false)
	@JsonIgnore
	private Country country;
	@OneToMany(mappedBy = "state", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Address> address;
}
