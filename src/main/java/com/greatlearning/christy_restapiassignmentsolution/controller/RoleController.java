package com.greatlearning.christy_restapiassignmentsolution.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.christy_restapiassignmentsolution.model.Role;
import com.greatlearning.christy_restapiassignmentsolution.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String addRole(@RequestBody Role role) {

		return roleService.createRole(role);
	}
}
