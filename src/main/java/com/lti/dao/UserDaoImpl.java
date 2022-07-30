package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.beans.User;


@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public User registerUser(User u) {		
		em.persist(u);
		User newUser = new User();
		newUser.setUser_id(u.getUser_id());
		newUser.setName(u.getName());
		newUser.setEmail(u.getEmail());
		newUser.setPassword(u.getPassword());
		newUser.setPhone(u.getPhone());
		
		return newUser;
	}


	@Override
	public User loginUser(User u) {
		System.out.println("In user Dao : "+u);
	
		return null;
	}


	@Override
	public User userEmailExist(String email) {
		TypedQuery<User> qr = em.createQuery("select u from User u where u.email=:email",User.class);
		qr.setParameter("email", email);
		List<User> userList = qr.getResultList();
		System.out.println(userList);
		
		if(userList.size()==0) {
			return new User();
		}else {
			User temp = userList.get(0);

			return temp;
		}
		
		

		
		
		
	}

}
