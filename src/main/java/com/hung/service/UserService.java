package com.hung.service;

import java.util.List;

import com.hung.model.Role;
import com.hung.model.User;

public interface UserService {

	List<User> userList();
	
	User findOne(Long id);
	
	User addUser(User user);
	
	String deleteUser(Long id);
	
	List<Role> roleList();
}
