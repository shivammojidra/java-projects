package crudtable.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import crudtable.model.MyUser;

@Component
public class CrudDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	//create User
	@Transactional
	public void createUser(MyUser myUser) {
		this.hibernateTemplate.save(myUser);
	}
	
	//get all users
	public List<MyUser> getAllUsers(){
		List<MyUser> users = this.hibernateTemplate.loadAll(MyUser.class);
		return users;
	}
	
	//delete single user
	@Transactional
	public void deleteUser(int uId) {
		MyUser myUser = this.hibernateTemplate.load(MyUser.class, uId);
		this.hibernateTemplate.delete(myUser);
	}
	
	//get single user
	public MyUser getUser(int uId) {
		MyUser myUser = this.hibernateTemplate.get(MyUser.class, uId);
		return myUser;
	}
	
	//update existing user
	@Transactional
	public void updateUser(MyUser myUser) {
		this.hibernateTemplate.update(myUser);
	}
	
	
}
