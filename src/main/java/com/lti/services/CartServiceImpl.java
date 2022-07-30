package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.beans.Cart;
import com.lti.dao.CartDao;

@Service(value="cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao dao;
	
	@Override
	public Cart addCart(Cart c) {
		return dao.addCart(c);
	}

	@Override
	public List<Cart> getProductsByUserId(int user_id) {
		return dao.getProductsByUserId(user_id);
	}


}
