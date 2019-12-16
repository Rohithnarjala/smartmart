package com.project.authenticationservice.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.authenticationservice.model.Users;







public class AppUser implements UserDetails {
	private Users user;
	private Collection<? extends GrantedAuthority> authorities; // to store role details

	public AppUser(Users user) {
		this.user = user;
		List<String> role=new ArrayList<String>();
		role.add(user.getUserType());
		role.add(user.getStatus());
		role.add(user.getFirstName());
		this.user=user;
		this.authorities = role.stream().map(value -> new SimpleGrantedAuthority(value))
				.collect(Collectors.toList());
		//System.out.println(this.authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
