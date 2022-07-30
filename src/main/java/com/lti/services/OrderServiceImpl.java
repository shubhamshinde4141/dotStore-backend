package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.beans.Order;
import com.lti.dao.OrderDao;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDao dao;

	@Override
	public Order addOrder(Order o) {
		return dao.addOrder(o);
	}

	@Override
	public List<Order> getOrdersByUserId(int user_id) {
		return dao.getOrdersByUserId(user_id);
	}

}
