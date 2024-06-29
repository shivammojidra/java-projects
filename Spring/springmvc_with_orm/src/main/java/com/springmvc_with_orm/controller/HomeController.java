package com.springmvc_with_orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc_with_orm.model.User;
import com.springmvc_with_orm.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	
	@RequestMapping(path = "/processForm", method = RequestMethod.POST)
	public String processForm(@ModelAttribute User user, Model model) {
		
		System.out.println(user);
		this.userService.createUser(user);
		return "success";
	}
	
	
	
}
