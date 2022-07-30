package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.beans.Retailer;
import com.lti.dao.RetailerDao;


@Service("retailerService")
public class RetailerServiceImpl implements RetailerService{
	
	@Autowired
	RetailerDao dao;

	@Override
	public Retailer registerRetailer(Retailer retailer) {
		return dao.registerRetailer(retailer);
	}

	@Override
	public int updateRetProfile(Retailer retailer) {
		return 0;
	}

	@Override
	public List<Retailer> getRetailer() {
		List<Retailer> retList=dao.getRetailer();
		return retList;
	}

	@Override
	public Retailer retailerEmailExist(String email) {
		Retailer retailerExist = dao.retailerEmailExist(email); 
		return retailerExist;
		
	}

}
