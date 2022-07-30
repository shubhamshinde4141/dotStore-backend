package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.beans.Cart;

@Repository
public class CartDaoImpl implements CartDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Cart addCart(Cart c) {
		em.persist(c);
		return c;
	}

	@Override
	public List<Cart> getProductsByUserId(int user_id) {
		TypedQuery<Cart> qry = em.createQuery("select c from Cart c where c.user.user_id=:user_id",Cart.class);
		qry.setParameter("user_id", user_id);
		List<Cart> cartList = qry.getResultList();
		return cartList;
	}



}
