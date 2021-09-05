package com.pos.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.customer.entity.Country;
import com.pos.customer.repository.CountryRepository;
@Service
public class CountryServiceImpl implements CountryService{
	@Autowired
	private CountryRepository countryRepository;
	@Override
	public ResponseEntity<String> addCountry(Country countryDetails) {
		// TODO Auto-generated method stub
		countryRepository.save(countryDetails);
		return new ResponseEntity<String>("Country Details Added Successfully!",new HttpHeaders(),HttpStatus.OK);
	}

}
