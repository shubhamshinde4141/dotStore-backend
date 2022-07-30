package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.beans.Admin;
import com.lti.dao.AdminDao;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao dao;
	
	@Override
	public int addAdmin(Admin a) {
		return dao.addAdmin(a);
	}

}
