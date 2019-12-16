package com.project.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.project.productservice.model.Users;
import com.project.productservice.service.UserService;

@RestController
@RequestMapping("/smartmart")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/admins")
	public List<Users> getAllPendingAdminList() {
		List<Users> adminList = null;
		adminList=userService.getAllPendingAdminList();
		return adminList;
	}
	
	@PutMapping("/admins")
	public void modifyApproval(@RequestBody Users user) {
		LOGGER.info("Start");
		userService.modifyApproval(user);
		System.out.println(user);
		LOGGER.info("End");
	} 
	@GetMapping("/user")
	public List<Users> getAllUsersForBilling() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return userService.getAllUsersForBilling();
	}
	@GetMapping("/users/user-id/{userID}")
	public Users getUserByUserID(@PathVariable String userID) {
		return userService.getUserByUserId(userID);
	}
	 
	@GetMapping("/users/contact-number/{contactNumber}")
	public Users getUserByContactNumber(@PathVariable long contactNumber) {
		return userService.getUserByContactNumber(contactNumber);
	}
	@PutMapping("/users/new-password")
	public void updatePassword(@RequestBody @Valid Users user)  {
		LOGGER.info("Start");
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		userService.updateUser(user);
		LOGGER.info("End");
	}
}
