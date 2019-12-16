package com.project.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="User Already Exixts")
public class UserAlreadyExistsException extends Exception{
	
	public UserAlreadyExistsException() {
		super("User Already Exists");
	}

}
 