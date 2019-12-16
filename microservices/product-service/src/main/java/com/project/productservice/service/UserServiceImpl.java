package com.project.productservice.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.productservice.model.Users;
import com.project.productservice.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepository userRepository;
	 
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@Override
	public List<Users> getAllPendingAdminList() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return userRepository.getAllPendingAdminList();
	}
	@Override
	public void modifyApproval(Users user) {
		LOGGER.info("Start");
		userRepository.save(user);
		LOGGER.info("End");
		
	}
	@Override
	public List<Users> getAllUsersForBilling() {
		// TODO Auto-generated method stub
		return userRepository.getAllUsersforbilling();
	}
	@Override
	public Users getUserByUserId(String userID) {
		// TODO Auto-generated method stub 
		return userRepository.findByUserId(userID);
	}
	@Override
	public Users getUserByContactNumber(long contactNumber) { 
		// TODO Auto-generated method stub
		return userRepository.findByContactNumber(contactNumber);
	}
	@Override
	public void updateUser(@Valid Users user) {
		userRepository.save(user);
		
	}

}
