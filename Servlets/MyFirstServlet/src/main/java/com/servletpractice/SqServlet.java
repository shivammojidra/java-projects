package com.servletpractice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SqServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int sum = (int)req.getAttribute("k");
		req.setAttribute("sqr", sum*sum);
		
		RequestDispatcher rd = req.getRequestDispatcher("/sqrt");
		rd.forward(req, resp);
//		resp.sendRedirect("redSer?k="+sum); //one way to share data between two servlets i.e. UrlRewriting
		
//		//Creating session variable for RedirectServlet
//		HttpSession session = req.getSession();
//		session.setAttribute("k", sum);  //another way to share data between two servlets using session
		
		
		//Sending Client cookie to share data with other servlets
//		Cookie cookie = new Cookie("k", sum+"");
//		resp.addCookie(cookie);
//		
//		
//		resp.sendRedirect("redSer");
		
//		int square = sum*sum;
//		
//		PrintWriter out = resp.getWriter();
//		out.print("<h1>Hii this is Sq Servlet</h1>");
//		out.print("The square of their sum is: "+square);
	}
}
