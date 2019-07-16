package com.pg.testapps.usermgmt.controller.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1522663216355691958L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
}
