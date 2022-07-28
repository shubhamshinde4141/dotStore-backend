package com.lti.services;

import java.util.List;

import com.lti.beans.Retailer;

public interface RetailerService {
	
	Retailer registerRetailer(Retailer retailer);	
//	loginRetailer()	
	int updateRetProfile(Retailer retailer);	
	List<Retailer> getRetailer();	
	public Retailer retailerEmailExist(String email);

}
