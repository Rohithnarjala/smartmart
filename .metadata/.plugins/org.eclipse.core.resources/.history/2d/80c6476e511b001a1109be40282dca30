package com.project.productservice.service;

import java.util.List;

import javax.validation.Valid;

import com.project.productservice.model.Users;



public interface UserService {
	public List<Users> getAllPendingAdminList();

	public void modifyApproval(Users user);

	public List<Users> getAllUsersForBilling();

	public Users getUserByUserId(String userID);

	public Users getUserByContactNumber(long contactNumber);

	public void updateUser(@Valid Users user);
}
