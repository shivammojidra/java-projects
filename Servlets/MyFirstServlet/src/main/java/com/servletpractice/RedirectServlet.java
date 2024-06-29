package com.servletpractice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/redSer")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//Getting Data with cookie
		Cookie cookies[] = req.getCookies();
		int k2=0;
		for(Cookie c:cookies) {
			if(c.getName().equals("k"))
				k2 = Integer.parseInt(c.getValue());
		}
		
		
		
//		//Getting data with session 
//		HttpSession session = req.getSession(); //Getting data with session
//		int k2 = (int)session.getAttribute("k"); //Getting data with session
		
//		int k2 = Integer.parseInt(req.getParameter("k")); //getting data with UrlRewriting
		
		PrintWriter out = resp.getWriter();
//		out.print("Redirected Servlet Square: "+k2*k2+" Parameter variable");
//		out.print("Redirected Servlet Square: "+k2*k2+" Session variable");
		out.print("Redirected Servlet Square: "+k2*k2+" Cookie variable");
		
		
		/*  <servlet>
  	<servlet-name>servletToRedirect</servlet-name>
  	<servlet-class>com.servletpractice.RedirectServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>servletToRedirect</servlet-name>
  	<url-pattern>/redSer</url-pattern>
  </servlet-mapping>*/
	}
}
