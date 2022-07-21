package com.greatlearning.christy_restapiassignmentsolution.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.christy_restapiassignmentsolution.model.Users;
import com.greatlearning.christy_restapiassignmentsolution.service.UsersService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UsersService usersService;

	public UserController(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createUser(@RequestBody Users user) {
		return usersService.creatUser(user);
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String updateUser(@RequestBody Users user, @RequestParam(name = "userId") long userId) {
		return usersService.UpdateUser(user, userId);
	}

}
