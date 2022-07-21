package com.greatlearning.christy_restapiassignmentsolution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.christy_restapiassignmentsolution.model.Users;
import com.greatlearning.christy_restapiassignmentsolution.repository.UserRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsersServiceImpl() {
	}

	@Override
	public String creatUser(Users users) {
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));

		userRepository.save(users);

		return "Success Created";
	}

	@Override
	public String UpdateUser(Users users, long userId) {

		Users user = userRepository.findById(userId).map(userToBeUpdated -> {
			userToBeUpdated.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
			userToBeUpdated.setUserName(users.getUsername());
			userToBeUpdated.setRoles(users.getRoles());
			return userToBeUpdated;
		}).orElseThrow(() -> new IllegalArgumentException("no record found"));
		userRepository.save(user);
		
		return "Successfully Updated";
	}

}
