package com.hung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.model.Role;
import com.hung.model.User;
import com.hung.repository.RoleRepository;
import com.hung.repository.UserRepository;
import com.hung.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}
	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}
	@Override
	public User addUser(User user) {
		user.setRole(roleRepository.findOne(user.getRole().getId()));
		return userRepository.save(user);
	}
	@Override
	public String deleteUser(Long id) {
		userRepository.delete(id);
		return "User deleted successfully !!!";
	}
	@Override
	public List<Role> roleList() {
		return roleRepository.findAll();
	}

	
}
