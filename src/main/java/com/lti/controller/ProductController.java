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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.beans.Category;
import com.lti.beans.Product;
import com.lti.responsemanager.ResponseHandler;
import com.lti.services.CategoryService;
import com.lti.services.ProductService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	ProductService service;
	
	
	@PostMapping("/add-product")
	public ResponseEntity<?> addProduct(@RequestBody Product c)
	{
		System.out.println("Inside Controller : "+c);
		Product pp =service.addProduct(c);
		return ResponseHandler.generateResponse("Product Created", HttpStatus.OK,pp);
	}
	
	
	@GetMapping("/get-all-product")
	public ResponseEntity<?> getAllProduct()
	{
		System.out.println("Inside Controller : ");
		List<Product> pp =service.getAllProducts();
		return ResponseHandler.generateResponse("All Products", HttpStatus.OK,pp);
	}
	
	
	@GetMapping("/get-product-byid/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id)
	{
		System.out.println("Inside Controller : ");
		Product pp =service.getProductById(id);
		return ResponseHandler.generateResponse("Product Detail", HttpStatus.OK,pp);
	}
	
	@GetMapping("/get-product-bycategory/{category_id}")
	public ResponseEntity<?> getProductByCategory(@PathVariable int category_id)
	{
		System.out.println("Inside Controller : ");
		List<Product> pp =service.getProductsByCategory(category_id);
		return ResponseHandler.generateResponse("Product By Category", HttpStatus.OK,pp);
	}
	
	
	
	
}
