package com.lti.dao;

import java.util.List;

import com.lti.beans.Product;

public interface ProductDao {

	public Product addProduct(Product p);
	public Product getProductById(int id);
	public List<Product> getAllProducts();
	public List<Product> getProductsByCategory(int category_id);
}
