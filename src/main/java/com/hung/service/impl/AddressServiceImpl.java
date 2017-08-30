package com.hung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.model.Address;
import com.hung.repository.AddressRepository;
import com.hung.repository.UserRepository;
import com.hung.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	private AddressRepository addressRepository;
	private UserRepository userRepository;
	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Address> addressList() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}

	@Override
	public Address addAddress(Address address) {
		address.setUser(userRepository.findOne(address.getUserId()));
		return addressRepository.save(address);
	}

	@Override
	public Address findOne(Long id) {
		// TODO Auto-generated method stub
		return addressRepository.findOne(id);
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.delete(id);
		return "'Message':'Deleted successfully !!!'";
	}
	
	
}
