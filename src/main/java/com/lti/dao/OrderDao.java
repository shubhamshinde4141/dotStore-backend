package com.lti.dao;

import java.util.List;

import com.lti.beans.Order;

public interface OrderDao {
	
	public Order addOrder(Order o);
	public List<Order> getOrdersByUserId(int user_id);

}
