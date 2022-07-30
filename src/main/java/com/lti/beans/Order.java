package com.lti.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ORDERSEQ")
	@SequenceGenerator(name="ORDERSEQ",sequenceName = "orderseq", allocationSize = 1)
	@Column(name="ORDER_ID")
	private int order_id;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="TOTALAMOUNT")
	private double totalAmount;
	
	@Column(name="PLACEDDATE")
	private String placedDate;
	
	@Column(name="STATUS")
	private int status;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	User user;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	Product product;

	public Order(int order_id, int quantity, double totalAmount, String placedDate, int status, User user,
			Product product) {
		super();
		this.order_id = order_id;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.placedDate = placedDate;
		this.status = status;
		this.user = user;
		this.product = product;
	}

	public Order() {
		super();
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(String placedDate) {
		this.placedDate = placedDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
		return "Order [order_id=" + order_id + ", quantity=" + quantity + ", totalAmount=" + totalAmount
				+ ", placedDate=" + placedDate + ", status=" + status + ", user=" + user + ", product=" + product + "]";
	}
	
	
	

}
