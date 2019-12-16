package com.project.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.productservice.model.Users;
import com.project.productservice.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
		Users user = userRepository.findByUserId(userID);
		UserDetails appUser = null;
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found!");
		} else {
			System.out.println("else:");
			appUser = new AppUser(user);
		}
		return appUser;
	} 

}
