package com.project.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.productservice.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	//public Users findByUserId(String us_name);
	
	@Query(nativeQuery = true, value = "SELECT * FROM user where us_status ='P'")
	List<Users> getAllPendingAdminList();
	
	@Query(nativeQuery = true, value = "select * from user where us_user_type='U'")
	public List<Users> getAllUsersforbilling();
	
	public Users findByUserId(String userID);
	
	public Users findByContactNumber(long contactNumber);
}
