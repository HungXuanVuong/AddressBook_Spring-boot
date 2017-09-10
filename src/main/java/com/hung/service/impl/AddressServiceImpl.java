package com.hung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.model.Address;
import com.hung.repository.AddressRepository;
import com.hung.repository.UserRepository;
import com.hung.service.AddressService;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
		return addressRepository.findAll();
	}

	@Override
	public String addAddress(Address address) {
		String message="";
		JSONObject jsonObject = new JSONObject();
		try {
			if(address.getId()==null){
				message=" added";
			}else{
				message=" updated";
			}
			address.setUser(userRepository.findOne(address.getUserId()));
			jsonObject.put("message", addressRepository.save(address).getCountry() + message + "successfully.");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public Address findOne(Long id) {
		return addressRepository.findOne(id);
	}

	@Override
	public String deleteAddress(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			addressRepository.delete(id);
			jsonObject.put("message", "Address deleted successfully !!!");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
}
