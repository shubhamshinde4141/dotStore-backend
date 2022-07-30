package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.beans.Admin;

@Repository
public class AdminDaoImpl implements AdminDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public int addAdmin(Admin a) {
		em.persist(a);
		return a.getAdmin_id();
	}

}
