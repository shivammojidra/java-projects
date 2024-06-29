package com.servletpractice;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mainnav")
public class MainFileNav extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("checklogin").include(req, resp);
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		//Use these three lines on each secured & restricted pages..
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //for http version 1.1
		resp.setHeader("Pragma", "no-cache"); //for HTTP 1.0
		resp.setHeader("Expires", "0"); //for proxy servers
		
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(60); //setting maximum inactivity time allowed
		if (session.getAttribute("LoginDone")!=null && (int)session.getAttribute("LoginDone")==1) { //if session is already there then send the data
			
			UserData ud1 = (UserData) session.getAttribute("user_data");
//				out.write("eligible");
			resp.getWriter().write("Email is: "+ ud1.getEmai() +"<br> Gender is: "+ ud1.getGender()+"<br> College is: "+ ud1.getCollege()+"<br> Course is: "+ ud1.getCourse());
			
				
		}else { //Else ask user to login again
			
			out.write("notEligible");
			
		}
		
	}
}
