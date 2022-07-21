package com.greatlearning.christy_restapiassignmentsolution.service;

import org.springframework.stereotype.Service;

import com.greatlearning.christy_restapiassignmentsolution.model.Role;
import com.greatlearning.christy_restapiassignmentsolution.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public String createRole(Role role) {

		roleRepository.save(role);
		return "success";

	}
}
