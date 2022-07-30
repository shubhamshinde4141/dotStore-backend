package com.lti.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CARTS")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CARTSEQ")
	@SequenceGenerator(name="CARTSEQ",sequenceName = "cartseq", allocationSize = 1)
	@Column(name="CART_ID")
	private int cart_id;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	User user;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	Product product;

	public Cart(int cart_id, int quantity, User user, Product product) {
		super();
		this.cart_id = cart_id;
		this.quantity = quantity;
		this.user = user;
		this.product = product;
	}

	public Cart() {
		super();
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", quantity=" + quantity + ", user=" + user + ", product=" + product + "]";
	}

	
	
	

}
