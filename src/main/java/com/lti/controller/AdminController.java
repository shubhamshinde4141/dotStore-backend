package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.beans.Admin;
import com.lti.responsemanager.ResponseHandler;
import com.lti.services.AdminService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin-api")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	
	// http://localhost:8090/admin-api/addadmin
	@PostMapping("/addadmin")
	public ResponseEntity<?> addAdmin(@RequestBody Admin a)
	{
		int adminId = service.addAdmin(a); //returns int
		return ResponseHandler.generateResponse("Added Successfully", HttpStatus.OK, adminId);
	}

}
