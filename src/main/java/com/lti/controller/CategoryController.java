package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.beans.Category;

import com.lti.services.CategoryService;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/cat-api")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	//http://localhost:8090/cat-api/addcategory
	@PostMapping("/addcategory")
	public int addCategory(@RequestBody Category c)
	{
		System.out.println("Inside Controller");
		int Id=service.addCategory(c);
		return Id;
	}
	
	//http://localhost:8090/cat-api/getcategorylist
	@GetMapping("/getcategorylist")
	public List<Category> getCategoryList() {
		List<Category> catList= service.getCategoryList();
		return catList;
	}
}
