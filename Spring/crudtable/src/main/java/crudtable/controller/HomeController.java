package crudtable.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crudtable.dao.CrudDao;
import crudtable.model.MyUser;

@Controller
public class HomeController {
	
	@Autowired
	private CrudDao crudDao;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<MyUser> users = crudDao.getAllUsers();
		m.addAttribute("users", users);
		System.out.println("At home Controller ");
		return "index";
	}
	
	@RequestMapping("/add-user")
	public String addUser(Model m) {
		m.addAttribute("title","Add User");
		return "add_user_form";
	}
	
	@RequestMapping(value = "/delete-user/{uId}", method = RequestMethod.GET)
	public RedirectView deleteUser(@PathVariable("uId") int userId,HttpServletRequest httpServletRequest) {
		
		this.crudDao.deleteUser(userId);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(httpServletRequest.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping(value = "/edit/{uId}")
	public String editForm(@PathVariable("uId") int userId,Model m) {
		//edit_user_form.jsp
		MyUser myUser = this.crudDao.getUser(userId);
		m.addAttribute("user", myUser);
		return "edit_user_form";
	}
	
	@RequestMapping(value = "/edit-user", method = RequestMethod.POST)
	public void handleEditForm(@ModelAttribute MyUser myUser,HttpServletResponse httpServletResponse) {
		System.out.println("Updated: "+myUser);
		
		
		try {
			
			try {
				//save to db
				crudDao.updateUser(myUser);			
				httpServletResponse.getWriter().write("Success");
			} catch (Exception e) {
				System.out.println("Exists");
				httpServletResponse.getWriter().write("Exists");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/experiment")
	public String jspTest() {
		return "testjsp";
	}
	
	@RequestMapping(value = "/save-user",method = RequestMethod.POST)
	public void test(@ModelAttribute MyUser myUser, HttpServletResponse httpServletResponse) {
		try {
			
			try {
				//save to db
				crudDao.createUser(myUser);			
				httpServletResponse.getWriter().write("Success");
			} catch (Exception e) {
				System.out.println("Exists");
				httpServletResponse.getWriter().write("Exists");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
