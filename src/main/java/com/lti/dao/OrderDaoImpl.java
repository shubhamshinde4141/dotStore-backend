package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.beans.Order;

@Repository
public class OrderDaoImpl implements OrderDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Order addOrder(Order o) {
		em.persist(o);
		return o;
	}

	@Override
	public List<Order> getOrdersByUserId(int user_id) {
		TypedQuery<Order> qry = em.createQuery("select o from Order o where o.user.user_id=:user_id",Order.class);
		qry.setParameter("user_id", user_id);
		List<Order> orderList = qry.getResultList();
		return orderList;
	}

}
