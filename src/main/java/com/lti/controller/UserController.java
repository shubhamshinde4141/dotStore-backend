package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lti.beans.User;
import com.lti.responsemanager.ResponseHandler;
import com.lti.services.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user-api")
public class UserController {

	@Autowired
	UserService service;
	
	//http://localhost:8090/user-api/register-user
	@PostMapping("/register-user")
	 public ResponseEntity<?>  registerUser(@RequestBody User u)
	 {
		 System.out.println("from postman : "+u);
		 
		 User exists = service.userEmailExist(u.getEmail());
		 
		 
		 
		 if(exists.getUser_id()!=0) {
			 return ResponseHandler.generateResponse("User Already Exixts", HttpStatus.CONFLICT,u);
			 //return new ResponseEntity<>("User Already Exixts", HttpStatus.CONFLICT);
			 
		 }
		 else {
			 
			 User user = service.registerUser(u);
			 return ResponseHandler.generateResponse("Registered Successfully", HttpStatus.OK,user);
			
		 }
	     
	 }
	
	
	
	//http://localhost:8090/user-api/login-user
	@PostMapping("/login-user")
	 public ResponseEntity<?> loginUser(@RequestBody User u)
	 {
		
		User exists = service.userEmailExist(u.getEmail());
		
		//check for user
		if(exists.getUser_id()!=0) {
			// user found
			//check password
			if(u.getPassword().equals(exists.getPassword())) {
				
				return ResponseHandler.generateResponse("User Login Successful", HttpStatus.OK,exists);
			}
			else {
				//password matched 
				return ResponseHandler.generateResponse("Password Not Matched", HttpStatus.UNAUTHORIZED,u);
			}
			
			 
		 }
		 else {
			 //user not found
			 return ResponseHandler.generateResponse("User Not Found", HttpStatus.NOT_FOUND,u);
			 
		 }
	     	    
	    
	 }
	
	
	
}
