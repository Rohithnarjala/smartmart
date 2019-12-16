package com.project.authenticationservice.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.authenticationservice.exception.UserAlreadyExistsException;
import com.project.authenticationservice.model.Users;
import com.project.authenticationservice.repository.UsersRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public AppUserDetailsService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUserId(username);
		UserDetails appUser = null;
		if (user == null) {
			throw new UsernameNotFoundException("User not found"); 
		} else {
			appUser = new AppUser(user);
			//System.out.println(appUser);
		}
		return appUser;
	}
	@Transactional
	public void signup(Users user) throws UserAlreadyExistsException {
		//boolean flag = false;
		if (usersRepository.findByUserId(user.getUserId()) != null) {
			//flag = false;
			throw new UserAlreadyExistsException();

		} else {
			//flag = true;
//			Set<Role> roleList = new HashSet();
//			roleList.add(new Role(1, "user"));
//			user.setRoleList(roleList);
			usersRepository.save(user);
		}
		//return flag;
	}
}