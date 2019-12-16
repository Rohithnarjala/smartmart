package com.project.productservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.productservice.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN").and()
		// .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
		// auth.userDetailsService(inMemoryUserDetailsManager());
		 auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
		//auth.userDetailsService(appUserDetailsService);
	}

 

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()
				.antMatchers("/smartmart/products").permitAll()
				.antMatchers("/smartmart/admins").permitAll()
				.antMatchers("/smartmart/addproduct").permitAll()
				.antMatchers("/smartmart/updateproduct").permitAll()
				.antMatchers("/smartmart/delete").permitAll() 
				.antMatchers("/smartmart/bills").permitAll()
				.antMatchers("/smartmart/user").permitAll()
				.antMatchers("/smartmart/users/user-id").permitAll()
				.antMatchers("/smartmart/users/contact-number").permitAll()
				.antMatchers("/smartmart/users/new-password").permitAll() 
				.antMatchers("/smartmart/product-list/sort-by-popularity").permitAll() 
				.antMatchers("/smartmart/offer").permitAll()
				.antMatchers("/smartmart/offer-list").permitAll()
				// .antMatchers("/smart-shop/authentication-service/authentication").anonymous()
				// .antMatchers("/truyum/authentication").hasAnyRole("USER", "ADMIN")
				// .antMatchers("/truyum/menu-items").permitAll().anyRequest().authenticated()
				.and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
		httpSecurity.cors();
	}
}
