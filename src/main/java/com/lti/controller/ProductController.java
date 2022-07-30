package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	@CrossOrigin(origins="http://localhost:8090")
	//http://localhost:8090/product-api/add-product
	@PostMapping("/add-product")
	public ResponseEntity<?> addProduct(@RequestBody Product c)
	{
		System.out.println("Inside Controller : "+c);
		Product pp =service.addProduct(c);
		return ResponseHandler.generateResponse("Product Created", HttpStatus.OK,pp);
	}
	
	//http://localhost:8090/product-api/get-all-product
	@GetMapping("/get-all-product")
	public ResponseEntity<?> getAllProduct()
	{
		System.out.println("Inside Controller : ");
		List<Product> pp =service.getAllProducts();
		return ResponseHandler.generateResponse("All Products", HttpStatus.OK,pp);
	}
	
	//http://localhost:8090/product-api/get-product-byid/2
	
	@GetMapping("/get-product-byid/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id)
	{
		System.out.println("Inside Controller : ");
		Product pp =service.getProductById(id);
		return ResponseHandler.generateResponse("Product Detail", HttpStatus.OK,pp);
	}
	
	//http://localhost:8090/product-api/get-product-bycategory/{category_id}
	@GetMapping("/get-product-bycategory/{category_id}")
	public ResponseEntity<?> getProductByCategory(@PathVariable int category_id)
	{
		System.out.println("Inside Controller : ");
		List<Product> pp =service.getProductsByCategory(category_id);
		return ResponseHandler.generateResponse("Product By Category", HttpStatus.OK,pp);
	}
	
	
	@PutMapping("/update-product/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable int id,@RequestBody Product c)
	{
		System.out.println("Inside Controller : "+c);
		// first get Product by id 
		Product pp1 =service.getProductById(id);
		
		// then update all fields with new object
		Product pp =service.updateProduct(id, pp1);
		System.out.println("After Update : "+pp);
		//Product pp =service.addProduct(c);
		return ResponseHandler.generateResponse("Product Updated", HttpStatus.OK,pp);
	}
	
	
	
	
	
}
