package com.greatlearning.christy_restapiassignmentsolution.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeControllerExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleNotFound(IllegalArgumentException e) {
		return e.getMessage();
	}

}
