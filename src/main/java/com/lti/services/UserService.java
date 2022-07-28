package com.lti.services;

import org.springframework.stereotype.Service;

import com.lti.beans.User;

@Service("userService")
public interface UserService {

	public User userEmailExist(String email);
	public User registerUser(User u);
	public User loginUser(User u);
	
}
