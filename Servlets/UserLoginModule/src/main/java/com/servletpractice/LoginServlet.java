package com.servletpractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		String uemail = req.getParameter("loginemail");
		String upass = req.getParameter("loginpass");
		
		ConnectionProvider c1 = new ConnectionProvider();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		Connection con = c1.getConnection();
		
		//Use these three lines on each secured & restricted pages..
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //for http version 1.1
		resp.setHeader("Pragma", "no-cache"); //for HTTP 1.0
		resp.setHeader("Expires", "0"); //for proxy servers
		
		if (con!=null) {
			System.out.println("Connection Received");
			try {
				String query = "select * from user_table where email=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, uemail);
				
				ResultSet resSet = pstmt.executeQuery();
				resSet.next();
				
				if (resSet.getRow()==1) {  //now check number of rows here i.e.  if(numRows==1)
					
					if (uemail.equals(resSet.getString(4)) && upass.equals(resSet.getString(3))) { //validate email & password here
						
						
						UserData uD1 = new UserData();
						uD1.setName(resSet.getString(2));
						uD1.setPassword(resSet.getString(3));
						uD1.setEmai(resSet.getString(4));
						uD1.setGender(resSet.getString(5));
						uD1.setCollege(resSet.getString(6));
						uD1.setCourse(resSet.getString(7));
						
						//Setting up session variables for User
						HttpSession session = req.getSession();
						session.setAttribute("LoginDone", 1);
						
						session.setAttribute("user_data", uD1);
						
						
						resp.getWriter().write("done");
						
//						resp.sendRedirect("mainnav");
					}else { // email & password doesn't match then 
						
						resp.getWriter().write("fail");
					}
					
				}else { // numRows!=1 then no user found
					
					resp.getWriter().write("unf");
							
				}
				con.close();
			} catch (SQLException e) { // exception
				resp.getWriter().write("conErr");
			}
			
		}else { // Connection error
			resp.getWriter().write("conErr");
		}
		

	}
}
