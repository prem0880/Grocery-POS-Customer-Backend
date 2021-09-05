package com.pos.customer.service;

import org.springframework.http.ResponseEntity;

import com.pos.customer.entity.Country;

public interface CountryService {
	ResponseEntity<String> addCountry(Country countryDetails);
}
