package com.hung.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hung.model.User;
import com.hung.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Username "+username+ "Not found !");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getGrantedAuthorities(user));
	}
	
	private Collection<GrantedAuthority> getGrantedAuthorities(User user){
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		if(user.getRole().getName().equals("admin")){
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return grantedAuthorities;
	}

}
