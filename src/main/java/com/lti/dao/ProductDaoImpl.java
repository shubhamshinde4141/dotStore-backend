package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.beans.Category;
import com.lti.beans.Product;
import com.lti.beans.User;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	@Transactional
	public Product addProduct(Product p) {
		// TODO Auto-generated method stub
		System.out.println(" Inside Dao method");		
		em.persist(p);	
		return p;
	}



	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Query qry=em.createQuery("Select p from Product p");
		List<Product> prodList=qry.getResultList();
		return prodList;
		
	}



	@Override
	public List<Product> getProductsByCategory(int category_id) {
		
		
		TypedQuery<Product> qr = em.createQuery("select p from Product p where p.category.id=:category_id",Product.class);
		qr.setParameter("category_id", category_id);
		List<Product> productList = qr.getResultList();
		System.out.println(productList);
		return productList;
	}



	@Override
	public Product getProductById(int id) {
		
		TypedQuery<Product> qr = em.createQuery("select p from Product p where p.product_id=:id",Product.class);
		qr.setParameter("id", id);
		List<Product> productList = qr.getResultList();
		
		if(productList.size()>0) {
			System.out.println(productList);
			return productList.get(0);
		}else {
			return new Product();
		}
		
		
		
	}



	@Override
	public Product updateProduct(int id, Product p) {
		// TODO Auto-generated method stub
		System.out.println(" Inside Dao method");	
		Product pp = em.merge(p);
		//em.persist(p);	
		return pp;
		
		
		
		
	}



	

}
