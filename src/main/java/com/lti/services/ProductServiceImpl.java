package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.beans.Product;
import com.lti.dao.ProductDao;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductDao dao;
	
	@Override
	public Product addProduct(Product p) {
		return dao.addProduct(p);
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public List<Product> getProductsByCategory(int category_id) {
		return dao.getProductsByCategory(category_id);
	}

	@Override
	public Product getProductById(int id) {
		return dao.getProductById(id);
	}

	@Override
	public Product updateProduct(int id, Product p) {
		return dao.updateProduct(id, p);
	}

	
}
