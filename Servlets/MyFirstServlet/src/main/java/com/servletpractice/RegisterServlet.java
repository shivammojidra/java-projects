package com.servletpractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.security.MD5Encoder;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("To Check When this method is executed...");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("<h1>Welcome "+req.getParameter("uname")+"!</h1>");
		
		String name = req.getParameter("uname");
		String password = req.getParameter("pass");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String college = req.getParameter("college");
		String course = req.getParameter("course");
		
//		out.print("Name: "+name+"<br/>");
//		out.print("Password: "+password+"<br/>");
//		out.print("Email: "+email+"<br/>");
//		out.print("Gender: "+gender+"<br/>");
//		out.print("College: "+college+"<br/>");
//		out.print("Course: "+course+"<br/>");
		
		try { // try here connecting with db & inserting the data into db
			
			//get connection variable
			//prepare the statement here with all the user data bound 
			//fire the query & then check
			
			String path = "C:\\Users\\shivamm\\eclipse-workspace\\servlet-workspace\\MyFirstServlet\\UserData\\";
			File myFile = new File(path+name+".txt");
			
			if (myFile.createNewFile()) {
//				out.print("Created Successfully"+"<br/>");
			}else {
//				out.print("Exists!!"+"<br/>");				
			}
			
			FileWriter writer = new FileWriter(myFile);
			StringJoiner strj = new StringJoiner("\n");
			strj.add("Name:"+name);
			strj.add("Password:"+password);
			strj.add("Email:"+email);
			strj.add("Gender:"+gender);
			strj.add("College:"+college);
			strj.add("Course:"+course);
			writer.write(strj.toString());
			out.print("Your Data Saved Successfully!"+"<br/>");
			writer.close();
			
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			
		} catch (Exception e) {
			out.print("Error Occured!! "+e);
		}
		
				
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroying Servlet");
	}
}
