package com.greatlearning.christy_restapiassignmentsolution.service;

import com.greatlearning.christy_restapiassignmentsolution.model.Users;

public interface UsersService {

	String creatUser(Users users);

	String UpdateUser(Users users, long userId);

}
