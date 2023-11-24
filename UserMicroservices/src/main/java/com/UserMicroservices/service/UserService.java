package com.UserMicroservices.service;

import java.util.List;

import com.UserMicroservices.entities.User;

public interface UserService {
	
	User createuser(User user);
	List<User> getAllUser();
	User getOneUser(String userId);

}
