package com.hung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hung.model.Address;
import com.hung.service.AddressService;
import com.hung.service.UserService;

@Controller
@RequestMapping("/address")
public class AddressController {

	private AddressService addressService;
	private UserService userService;

	@Autowired
	public AddressController(AddressService addressService, UserService userService) {
		this.addressService = addressService;
		this.userService = userService;
	}
	
	@GetMapping("/list/{id}")
	public Address findOne(@PathVariable Long id){
		return addressService.findOne(id);
	}
	
	@GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public @ResponseBody String deleteAddress(@PathVariable Long id){
		return addressService.deleteAddress(id);
	}
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public @ResponseBody String addAddress(@RequestBody Address address){
		return addressService.addAddress(address);
	}
	
	@GetMapping("/edit/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String editAddress(@PathVariable Long id, Model model){
		model.addAttribute("addressForm", addressService.findOne(id));
		model.addAttribute("users", userService.userList());
		return "/address/form";
	}
	@GetMapping("/list")
	public String addressList(Model model){
		model.addAttribute("addresses", addressService.addressList());
		return "/address/list";
	}
	
	@GetMapping("/form")
	public String addressForm(Model model){
		model.addAttribute("addressForm", new Address());
		model.addAttribute("users", userService.userList());
		return "/address/form";
	}
	
}
