package com.pos.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Address;
import com.pos.customer.entity.Customer;
import com.pos.customer.entity.OAuth;
import com.pos.customer.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/profile")
	public Customer getProfile(@RequestParam("customer-id")Long customerId) {
		return profileService.getProfile(customerId);
	}
	
	@PostMapping("/update-profile")
	public Customer updateProfile(@RequestBody Customer customer) {
		return profileService.updateProfile(customer);
	}
	
	@PostMapping("/activate-profile")
	public OAuth activateProfile(@RequestBody OAuth oauth) {
		return profileService.activateProfile(oauth);
	}
	
	@PostMapping("/deactivate-profile")
	public OAuth deactivateAccount(@RequestBody OAuth oauth) {
		return profileService.deactivateAccount(oauth);
	}
	
	@PostMapping("/add-address")
	public Address addAddress(@RequestBody Address address) {
		return profileService.addAddress(address);
	}
	
	@PostMapping("/update-address")
	public Address updateAddress(@RequestBody Address address) {
		return profileService.updateAddress(address);
	}
	
	@PostMapping("/delete-address")
	public Address deleteAddress(@RequestParam("address-id") Long id) {
		return profileService.deleteAddress(id);
	}
	
	@GetMapping("/address")
	public Address getAddress(@RequestParam("address-id") Long addressId) {
		return profileService.getAddress(addressId);
	}
	
	@GetMapping("/addresses")
	public List<Address> getAddresses(@RequestParam("profile-id") Long profileId){
		return profileService.getAddresses(profileId);
	}
}
