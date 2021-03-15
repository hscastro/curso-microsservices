package com.crud.hscastro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -544298359978446103L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}		
}
