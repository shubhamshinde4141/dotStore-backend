package com.lti.controller;

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


import com.lti.beans.Retailer;
import com.lti.responsemanager.ResponseHandler;
import com.lti.services.RetailerService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/retailer-api")
public class RetailerController {
	
	@Autowired
	RetailerService service;
	
//	
//	//http://localhost:8090/retailer-api/register-retailer
//	@PostMapping("/register-retailer")
//	public int registerRetailer(@RequestBody Retailer retailer)
//	{
//		System.out.println("Inside Controller");
//		int id=service.registerRetailer(retailer);
//		return id;
//	}
	
	//http://localhost:8090/retailer-api/register-retailer
	
	@PostMapping("/register-retailer")
	 public ResponseEntity<?>  registerUser(@RequestBody Retailer r)
	 {
		 System.out.println("from postman : "+r);
		 
		 Retailer exists = service.retailerEmailExist(r.getEmail());
		 
		 
		 
		 if(exists.getId()!=0) {
			 return ResponseHandler.generateResponse("Retailer Already Exixts", HttpStatus.CONFLICT,r);
			 //return new ResponseEntity<>("User Already Exixts", HttpStatus.CONFLICT);
			 
		 }
		 else {
			 
			 Retailer retailer = service.registerRetailer(r);
			 return ResponseHandler.generateResponse("Registered Successfully", HttpStatus.OK,retailer);
			
		 }
	     
	 }
	
	
	
	@PostMapping("/login-retailer")
	 public ResponseEntity<?> loginUser(@RequestBody Retailer r)
	 {
		
		
		Retailer exists = service.retailerEmailExist(r.getEmail());
		
		System.out.println("Retailer exists:"+exists.getPassword());
		System.out.println("body user:"+r.getPassword());
		
		if(exists.getId()!=0) {
			// user found
			//check password
			if(r.getPassword().equals(exists.getPassword())) {
				
				return ResponseHandler.generateResponse("User Login Successful", HttpStatus.OK,exists);
			}
			else {
				//password matched 
				return ResponseHandler.generateResponse("Password Not Matched", HttpStatus.UNAUTHORIZED,r);
			}
			
			 
		 }
		 else {
			 //user not found
			 return ResponseHandler.generateResponse("User Not Found", HttpStatus.NOT_FOUND,r);
			 
		 }
	     	    
	    
	 }
		
			
	


	
	//http://localhost:8090/ret-api/getretailer
	@GetMapping("/getretailer")
	public List<Retailer> getRetailer() {
		List<Retailer> retList= service.getRetailer();
		return retList;
	}

}
