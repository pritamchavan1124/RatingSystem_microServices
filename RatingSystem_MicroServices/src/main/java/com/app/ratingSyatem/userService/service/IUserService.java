package com.app.ratingSyatem.userService.service;

import java.util.List;
import java.util.Optional;

import com.app.ratingSyatem.userService.entities.User;
import com.app.ratingSyatem.userService.exception.ResourseNotFoundException;

public interface IUserService {

	//create new User
	User saveUser(User user);
	
	//get all user list
	List<User> getAllUser();
	
	//get single user of given userId
	Optional<User> getUser(String userId) throws ResourseNotFoundException;
	
	//delete user of given id
	String deleteUserById(String userId);
	
	//update user by given id
	String updateUser(User user);
}
