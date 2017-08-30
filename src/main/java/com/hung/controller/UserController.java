package com.hung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hung.model.User;
import com.hung.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public List<User> userList(){
		return userService.userList();
	}
	@RequestMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete(@PathVariable Long id){
		return userService.deleteUser(id);
	}
	
	@RequestMapping("/add")
	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public User addUser(@RequestBody User user){
		return userService.addUser(user);
	}
	@RequestMapping("/list/{id}")
	public User findOne(@PathVariable Long id){
		return userService.findOne(id);
	}
}
