package com.servletpractice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	private int visit_cnt;
	
	@Override
	public void init() throws ServletException {
		visit_cnt=0;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Serving...");
		System.out.println("Visit Count "+ ++visit_cnt);
		
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int k = i+j;
//		req.setAttribute("k", k);
//		
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, resp);
		
//		 PrintWriter out=resp.getWriter();  
//         
//	        out.print("<html><body>");  
//	        out.print("<h3>Hello Servlet</h3>"); 
//	        out.print("Addition of two numbers is: "+(num1+num2));
//	        out.print("</body></html>");  
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("<h1>Post Method Not Allowed Here</h1>");
	}
}
