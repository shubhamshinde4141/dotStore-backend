package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.beans.Retailer;

@Repository
public class RetailerDaoImpl implements RetailerDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Retailer registerRetailer(Retailer retailer) {
		em.persist(retailer);
		return retailer;
	}

	@Override
	public int updateRetProfile(Retailer retailer) {
		return 0;
	}

	@Override
	public List<Retailer> getRetailer() {
		Query qry=em.createQuery("Select r from Retailer r");
		List<Retailer> retailerList=qry.getResultList();
		return retailerList;
	}

	@Override
	public Retailer retailerEmailExist(String email) {
		TypedQuery<Retailer> qr = em.createQuery("select r from Retailer r where r.email=:email",Retailer.class);
		qr.setParameter("email", email);
		List<Retailer> RetailerList = qr.getResultList();
		System.out.println(RetailerList);
		
		if(RetailerList.size()==0) {//retailer not exists with same mail
			return new Retailer();
		}else {
			Retailer temp = RetailerList.get(0);

			return temp;
		}
		
	}

}