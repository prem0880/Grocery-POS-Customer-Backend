package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pos.customer.entity.Customer;
import com.pos.customer.repository.CustomerRepository;
import com.pos.customer.entity.Address;
import com.pos.customer.entity.Country;
import com.pos.customer.entity.Customer;
import com.pos.customer.entity.State;
import com.pos.customer.service.ProfileService;

@RestController
@RequestMapping("/profile")

public class ProfileController {
	@Autowired
	private ProfileService customerService;

    @PostMapping("/createProfile") 
    public ResponseEntity<String> createCustomer( @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
    	
	@PostMapping("/addCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country countryDetails) {
		return customerService.addCountry(countryDetails);
	}

	@PostMapping("/country/{countryCode}/addState")
	public ResponseEntity<String> addState(@PathVariable("countryCode") Long countryCode,
			@RequestBody State stateDetails) {
		return customerService.addState(countryCode, stateDetails);
	}

	@GetMapping("getCustomer/{phoneNo}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable("phoneNo") Long phoneNo) {
		return customerService.getCustomerDetails(phoneNo);
	}

	@PutMapping("/updateCustomer/{phoneNo}")
	public ResponseEntity<String> updateCustomer(@PathVariable("phoneNo") Long phoneNo,
			@RequestBody Customer customerDetails) {
		return customerService.updateCustomer(phoneNo, customerDetails);
	}

	@PostMapping("/customer/{customerId}/state/{stateId}/addAddress")
	public ResponseEntity<String> addAddress(@PathVariable("customerId") Long customerId,
			@PathVariable("stateId") Long stateId, @RequestBody Address addressDetails) {
		return customerService.addAddress(customerId, stateId, addressDetails);
	}

	@GetMapping("/getAddress/{customerId}")
	public ResponseEntity<List<Address>> getAddressByCustomerId(@PathVariable("customerId") Long customerId) {
		return customerService.getAddressByCustomerId(customerId);
	}

	@PutMapping("/activateProfile/{phoneNo}")
	public ResponseEntity<String> activateProfile(@PathVariable("phoneNo") Long phoneNo, String status) {
		return customerService.activateProfile(phoneNo, "Activated");
	}

	@PutMapping("/deActivateProfile/{phoneNo}")
	public ResponseEntity<String> deActivateProfile(@PathVariable("phoneNo") Long phoneNo, String status) {
		return customerService.deActivateProfile(phoneNo, "Deactivated");
	}
	
	@PutMapping("/updateAddress/{customerId}")
	public ResponseEntity<Address> updateAddress(@PathVariable("customerId") Long customerId,
			@RequestBody Address addressDetails){
		return customerService.updateAddress(customerId,addressDetails);
	}
   
	@DeleteMapping("/deleteAddress/{customerId}")
	public ResponseEntity<String> deleteAddress(@PathVariable("customerId") Long customerId) {
		return customerService.deleteAddress(customerId);
	}

}
