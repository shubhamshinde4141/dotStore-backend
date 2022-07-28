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
		// TODO Auto-generated method stub
		
		System.out.println("In user Service : "+u);
		
		//call dao
		User user = dao.registerUser(u);
		
		System.out.println(user);
		
		return user;
	}



	@Override
	public User loginUser(User u) {
		
		System.out.println("In user Service : "+u);
		
		//call dao
		User user = dao.registerUser(u);
		
		System.out.println(user);
		
		return user;
	}



	@Override
	public User userEmailExist(String email) {
		// TODO Auto-generated method stub
		User userExist = dao.userEmailExist(email); 
		return userExist;
	}



}
