package com.hung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hung.model.User;
import com.hung.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String userList(Model model){
		model.addAttribute("users", userService.userList());
		return "/user/list";
	}
	
	@GetMapping("/form")
	public String userForm(Model model){
		model.addAttribute("userForm", new User());
		model.addAttribute("roles", userService.roleList());
		return "/user/form";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete(@PathVariable Long id, Model model){
		model.addAttribute("message", userService.deleteUser(id));
		return "message";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id, Model model){
		model.addAttribute("userForm", userService.findOne(id));
		model.addAttribute("roles", userService.roleList());
		return "/user/form";
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addUser(@ModelAttribute User user, Model model){
		String message = "";
		if(user.getId() == null){
			message=" added";
		}else{
			message=" updated";
		}
		model.addAttribute("message", userService.addUser(user).getUserName() + message + " successfully!!!");
		return "message";
	}
	@GetMapping("/list/{id}")
	public User findOne(@PathVariable Long id){
		return userService.findOne(id);
	}
}
