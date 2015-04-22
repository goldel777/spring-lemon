package com.naturalprogrammer.spring.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.naturalprogrammer.spring.boot.user.BaseUser;
import com.naturalprogrammer.spring.boot.user.UserService;

@Service
class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService; 
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		
		BaseUser baseUser = userService.findByEmail(email);
		if (baseUser == null)
			throw new UsernameNotFoundException(email);

		return new UserDetailsImpl(baseUser);

	}

}