package com.springmvc_with_orm.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc_with_orm.model.User;


@Repository  //no need to configure this in xml
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate; // but for hibTemp we've to configure xml, so go tomyServlet-servlet.xml
	
	@Transactional
	public int saveUser(User user) {
		return (Integer)this.hibernateTemplate.save(user);
	}
}
