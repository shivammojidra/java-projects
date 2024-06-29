package com.springmvc_with_orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc_with_orm.dao.UserDao;
import com.springmvc_with_orm.model.User;


@Service //no need to configure this in xml
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public int createUser(User user) {
		return this.userDao.saveUser(user);
	}
}
