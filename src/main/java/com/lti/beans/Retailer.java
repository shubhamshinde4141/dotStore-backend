package com.lti.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Retailer")
public class Retailer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="RETAILERSEQ")
	@SequenceGenerator(name="RETAILERSEQ", sequenceName="retailerseq",allocationSize=1)
	@Column(name="ID")
	private int id;
	
	
	@Column(name="OWNERNAME")
	private String ownerName;
	
	@Column(name="SHOPNAME")
	private String shopName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE", length=10)
	private long phone;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="AUTHENTICATE")
	private boolean authenticate;
	
	@Column(name="ADDRESS")
	private String address;
	
	
	public Retailer() {
		super();
	}


	public Retailer(int id, String shopName, String ownerName, String email, long phone, String password,
			boolean authenticate, String address) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.ownerName = ownerName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.authenticate = authenticate;
		this.address = address;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getShopName() {
		return shopName;
	}


	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean getAuthenticate() {
		return authenticate;
	}


	public void setAuthenticate(boolean authenticate) {
		this.authenticate = authenticate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Retailer [Id=" + id + ", shopName=" + shopName + ", ownerName=" + ownerName + ", email="
				+ email + ", phone=" + phone + ", password=" + password + ", authenticate=" + authenticate
				+ ", address=" + address + "]";
	}	
	
	
	
}