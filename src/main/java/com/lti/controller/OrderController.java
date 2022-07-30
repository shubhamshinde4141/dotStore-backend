package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.beans.Order;
import com.lti.responsemanager.ResponseHandler;
import com.lti.services.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order-api")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	//http://localhost:8090/order-api/add-order
	@PostMapping("/add-order")
	public ResponseEntity<?> addOrder(@RequestBody Order o)
	{
		Order oo = service.addOrder(o);
		return ResponseHandler.generateResponse("Order placed successfully", HttpStatus.OK, oo);
	}
	
	//http://localhost:8090/order-api/get-order-byuserid/{user_id}
	@GetMapping("/get-order-byuserid/{user_id}")
	public ResponseEntity<?> getOrderByUserId(@PathVariable int user_id)
	{
		List<Order> orderList = service.getOrdersByUserId(user_id);
		return ResponseHandler.generateResponse("Orders of User Id: "+user_id, HttpStatus.OK, orderList);
	}
}
