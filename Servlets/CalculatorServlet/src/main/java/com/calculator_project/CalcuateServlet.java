package com.calculator_project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculate")
public class CalcuateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		System.out.println(req.getParameter("equation"));
		
			String answer =req.getParameter("equation")+"=";
			String tempString = req.getParameter("equation");
			double solution=0;
			
			try {
//				
				InfixEvaluate evaluate = new InfixEvaluate();
				
				//req.setAttribute("expression", tempString);
				//req.getRequestDispatcher("evaluate").include(req, resp);
				
//				solution = (Double)req.getAttribute("sol");
				solution = (Double)evaluate.evaluate(tempString);
				answer=String.valueOf(solution);				
				
			} catch (Exception e) {
				answer = "Syntax Error";
			}
			
			out.write(answer);
			
			
		
		
	}
}
