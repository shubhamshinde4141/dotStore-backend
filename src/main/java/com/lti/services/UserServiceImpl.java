package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.beans.User;
import com.lti.dao.UserDao;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	
	
	@Override
	public User registerUser(User u) {		
		//call dao
		User user = dao.registerUser(u);		
		return user;
	}



	@Override
	public User loginUser(User u) {
	
		//call dao
		User user = dao.registerUser(u);		
		return user;
	}



	@Override
	public User userEmailExist(String email) {
		User userExist = dao.userEmailExist(email); 
		return userExist;
	}



}
