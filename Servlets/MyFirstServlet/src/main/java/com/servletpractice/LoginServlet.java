package com.servletpractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//pull vs fetch
		//merge & rebe
		
		String uname = req.getParameter("loginname");
		String upass = req.getParameter("loginpass");
		String path = "C:\\Users\\shivamm\\eclipse-workspace\\servlet-workspace\\MyFirstServlet\\UserData\\";
		
		
		//get a connection variable from here
		//prepare the statements with email set into statement 
		//Fire a query with the email user entered  & get password
		//get email & password into the variables
		
		File myFile = new File(path+uname+".txt");
		PrintWriter out = resp.getWriter();
		if (myFile.exists()) {  //now check number of rows here i.e.  if(numRows==1)
			
			BufferedReader br = new BufferedReader(new FileReader(myFile));
			
			String str = br.readLine();
			String str2 = br.readLine();
			String dataName = str.substring(5);
			String dataPass = str2.substring(9);
			
			if (uname.equals(dataName) && upass.equals(dataPass)) { //validate email & password here
				String dataEmail = br.readLine().substring(6);
				String dataGender = br.readLine().substring(7);
				String dataCollege = br.readLine().substring(8);
				String dataCourse = br.readLine().substring(7);
				out.print("<h1>Welcome to Login Servlet</h1>");
				out.print("<h1>Welcome "+uname+"</h1><br/>");
				out.print("Email: "+dataEmail+"<br/>");
				out.print("Gender: "+dataGender+"<br/>");
				out.print("College: "+dataCollege+"<br/>");
				out.print("Course: "+dataCourse+"<br/>");
				br.close();
				
				
				//Setting up session variables for User
				HttpSession session = req.getSession();
				session.setAttribute("LoginDone", 1);
				session.setAttribute("Name", dataName);
				session.setAttribute("Password", dataPass);
				session.setAttribute("Email", dataEmail);
				session.setAttribute("Gender", dataGender);
				session.setAttribute("College", dataCollege);
				session.setAttribute("Course", dataCourse);  
				
				resp.sendRedirect("mainnav");
			}else { // email & password doesn't match then 
			out.print("<h1>Wrong Credentials</h1>");
			
			out.print("<a href='Login.html'>Login Again!....</a><br/>");
			out.print("<a href='index.html'>New User? Register here....</a>");
		}
			
		}else { // numRows!=1 then no user found
			out.print("<h1>No Data Found For This User</h1>");
			
			out.print("<a href='Login.html'>Login Again!....</a><br/>");
			out.print("<a href='index.html'>New User? Register here....</a>");			
		}
		
//		out.print("Login name "+uname+" "+uname.length()+"<br/>");
//		out.print("Login pass "+upass+" "+upass.length()+"<br/>");
//		out.print("Hello "+dataName+" "+dataName.length()+"<br/>");
//		out.print("PassWord "+dataPass+" "+dataPass.length());
	}
}
