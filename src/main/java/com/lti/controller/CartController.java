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

import com.lti.beans.Cart;
import com.lti.responsemanager.ResponseHandler;
import com.lti.services.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart-api")
public class CartController {
	
	@Autowired
	CartService service;
	
	//http://localhost:8090/cart-api/add-cart
	@PostMapping("/add-cart")
	public ResponseEntity<?> addCart(@RequestBody Cart c)
	{
		Cart cc = service.addCart(c);//returns object Cart
		return ResponseHandler.generateResponse("Cart Created", HttpStatus.OK,cc);
	}
	
	//http://localhost:8090/cart-api/get-product-byuserid/{user_id}
	@GetMapping("/get-product-byuserid/{user_id}")//get by user id
	public ResponseEntity<?> getProductByUserId(@PathVariable int user_id)
	{
		List<Cart> cartList = service.getProductsByUserId(user_id);//returns list of Cart objects
		return ResponseHandler.generateResponse("Cart of User Id: "+user_id, HttpStatus.OK, cartList);
	}
	
	


}
