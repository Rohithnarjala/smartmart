package com.project.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.project.authenticationservice.model.Users;





@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	public Users findByUserId(String us_name) throws UsernameNotFoundException;
	
	
}
