package com.lti.services;



import java.util.List;

import com.lti.beans.Category;


public interface CategoryService {
	
	int addCategory(Category c);
	List<Category> getCategoryList();
	

}
