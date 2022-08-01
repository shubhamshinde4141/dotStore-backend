package com.lti.dao;

import com.lti.beans.User;

public interface UserDao {

	public User registerUser(User u);
	public User userEmailExist(String email);
	public User getUserById(int id);
	public User loginUser(User u);
	
}
