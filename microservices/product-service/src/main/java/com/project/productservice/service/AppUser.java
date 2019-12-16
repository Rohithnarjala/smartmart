package com.project.productservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.productservice.model.Users;

public class AppUser implements UserDetails {
	private Users user;
	private Collection<? extends GrantedAuthority> authorities;

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(Users user) {
		super();
		List<String> role = new ArrayList<String>();
		role.add(user.getUserType());
		role.add(user.getStatus());
		role.add(user.getFirstName());
		this.user = user;
		this.authorities = role.stream().map(value -> new SimpleGrantedAuthority(value))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		System.out.println(user.getPassword());
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
