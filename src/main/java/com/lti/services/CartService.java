package com.lti.services;

import java.util.List;

import com.lti.beans.Cart;

public interface CartService {
	
	public Cart addCart(Cart c);

	public List<Cart> getProductsByUserId(int user_id);
	


}
