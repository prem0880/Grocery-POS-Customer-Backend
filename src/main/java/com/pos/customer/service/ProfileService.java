package com.pos.customer.service;


import java.util.List;

import com.pos.customer.entity.Customer;
import com.pos.customer.entity.OAuth;
import com.pos.customer.entity.Address;

public interface ProfileService {
	Customer getProfile(Long customerId);
	Customer updateProfile(Customer customer);
	OAuth activateProfile(OAuth oauth);
	OAuth deactivateAccount(OAuth oauth);
	Address addAddress(Address address);
	Address updateAddress(Address address);
	Address deleteAddress(Long id);
	Address getAddress(Long addressId);
	List<Address> getAddresses(Long profileId);
}
