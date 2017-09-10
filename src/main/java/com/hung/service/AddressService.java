package com.hung.service;


import java.util.List;

import com.hung.model.Address;

public interface AddressService {
	
	List<Address> addressList();
	
	String addAddress(Address address);
	
	Address findOne(Long id);
	
	String deleteAddress(Long id);
}
