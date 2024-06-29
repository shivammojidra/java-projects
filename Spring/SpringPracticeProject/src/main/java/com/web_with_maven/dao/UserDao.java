package com.web_with_maven.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.web_with_maven.entities.User;


public class UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public User getSingleUser(int userId) {
		return this.hibernateTemplate.get(User.class, userId);
	}

	
	@Transactional
	public int insert(User user) {
		
		//insert logic
		
		Integer i = (Integer)this.hibernateTemplate.save(user);
		
		return i;
	}
	
	
	public List<User> getAllUsers(){
		return this.hibernateTemplate.loadAll(User.class);
	}
	
	@Transactional
	public void deleteUser(int userId) {
		User user = this.hibernateTemplate.get(User.class, userId);
		this.hibernateTemplate.delete(user);
	}
	
	@Transactional
	public void updateUser(User user) {
		this.hibernateTemplate.update(user);
	}
	
}
