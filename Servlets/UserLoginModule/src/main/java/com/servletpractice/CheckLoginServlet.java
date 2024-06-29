package com.servletpractice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/checklogin")
public class CheckLoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("LoginDone")!=null&&(int)session.getAttribute("LoginDone")==1) {
			// Login Done!! Proceed Ahead...
		}else {
			// User is Not logged in so redirecting user to login page
			resp.sendRedirect("login1.html");
			resp.getWriter().write("login_again");
		}
	}
}
