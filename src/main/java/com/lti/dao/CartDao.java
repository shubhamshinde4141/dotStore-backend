package com.lti.dao;

import java.util.List;

import com.lti.beans.Cart;

public interface CartDao {
	
	public Cart addCart(Cart c);
	public List<Cart> getProductsByUserId(int user_id);


}
