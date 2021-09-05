package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Country;
import com.pos.customer.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryService countryServiceImpl;
	@PostMapping("/addCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country countryDetails)
	{
		return countryServiceImpl.addCountry(countryDetails);
	}
}
