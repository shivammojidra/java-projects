package com.servletpractice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		RequestDispatcher rd = req.getRequestDispatcher("checklogin");
		rd.include(req, resp);
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession session = req.getSession();
//		session.setAttribute("LoginDone", 0);
//		out.print(session.getAttribute("LoginDone"));
		
		if (session.getAttribute("LoginDone")!=null) {
			
			if ((int)session.getAttribute("LoginDone")==1) {
//			resp.sendRedirect("MainFile.html");
				out.print("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Main File</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<h1>This is the main file for navigation</h1>\r\n"
						+ "<button>Do Nothing</button>\r\n"
						+ "<a href=\"logout\">Logout</a>\r\n");
				out.print("<h2>Welcome "+ session.getAttribute("Name")+"! </h2>");
				out.print("Your Details are...<br/>");
				out.print("Email is: "+session.getAttribute("Email")+"<br/>");
				out.print("Gender is: "+session.getAttribute("Gender")+"<br/>");
				out.print("College is: "+session.getAttribute("College")+"<br/>");
				out.print("Course is: "+session.getAttribute("Course")+"<br/>");
				
				out.print("</body>\r\n"
						+ "</html>");
				
				
			}else {
				out.print("<h1>Login Again!!</h1>");
				out.print("Looks like You've Logged Out!<br/>");
				out.print("Login Status "+session.getAttribute("LoginDone")+"<br/>");
				out.print("<a href='Login.html'>Login</a>");
//			out.print(session.getAttribute("Name")+" Login Name");
			}
		}else {
			out.print("<h1>Login Again!!</h1>");
			out.print("Looks like You've Logged Out!<br/>");
//			out.print("Login Status "+session.getAttribute("LoginDone")+"<br/>");
			out.print("<a href='Login.html'>Login</a>");
			
		}
		
	}
}
