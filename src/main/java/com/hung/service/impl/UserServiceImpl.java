package com.hung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.model.User;
import com.hung.repository.UserRepository;
import com.hung.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
		return "{'message':'User deleted successfully.'}";
	}

	
}
