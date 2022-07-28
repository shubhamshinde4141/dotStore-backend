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
@Table(name="PRODUCTS")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="PRODSEQ")
	@SequenceGenerator(name="PRODSEQ", sequenceName="prodseq",allocationSize=1)
	@Column(name="PRODUCT_ID")
	private int product_id;
	
	@Override
	public String toString() {
		return "Product [id=" + product_id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
				+ stock + ", isAvailable=" + isAvailable + ", imageUrl=" + imageUrl + ", category=" + category
				+ ", retailer=" + retailer + "]";
	}


	public Product() {
		super();
	}


	public Product(int id, String name, String description, double price, int stock, boolean isAvailable,
			String imageUrl, Category category, Retailer retailer) {
		super();
		this.product_id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.isAvailable = isAvailable;
		this.imageUrl = imageUrl;
		this.category = category;
		this.retailer = retailer;
	}


	public int getId() {
		return product_id;
	}


	public void setId(int id) {
		this.product_id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Retailer getRetailer() {
		return retailer;
	}


	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}


	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="STOCK")
	private int stock;
	
	@Column(name="ISAVAILABLE")
	private boolean isAvailable;
	
	@Column(name="IMAGEURL")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	Category category;
	
	
	@ManyToOne
	@JoinColumn(name="ID")
	Retailer retailer;
}

