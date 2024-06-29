package com.servletpractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("To Check When this method is executed...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
//		out.print("<h1 align=\"center\">Welcome "+req.getParameter("uname")+"!</h1>");

		UserData registerUserData = new UserData();

		registerUserData.setName(req.getParameter("uname"));
		registerUserData.setPassword(req.getParameter("pass"));
		registerUserData.setEmai(req.getParameter("email"));
		registerUserData.setGender(req.getParameter("gender"));
		registerUserData.setCollege(req.getParameter("college"));
		registerUserData.setCourse(req.getParameter("course"));

		try { // try here connecting with db & inserting the data into db

			// get connection variable
			// prepare the statement here with all the user data bound
			// fire the query & then check
			ConnectionProvider c1 = new ConnectionProvider();
			Connection con = c1.getConnection();

			if (con != null) {
				System.out.println("Connection Received");

				String queryCheck = "select * from user_table where email = ?";
				PreparedStatement pstmtCheck = con.prepareStatement(queryCheck);
				pstmtCheck.setString(1, registerUserData.getEmai());
				ResultSet rSet = pstmtCheck.executeQuery();
				rSet.next();

				if (rSet.getRow() == 0) { // if no user with the same name exists then only proceed
					String query = "insert into user_table (name,password,email,gender,college,course) values(?,?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, registerUserData.getName());
					pstmt.setString(2, registerUserData.getPassword());
					pstmt.setString(3, registerUserData.getEmai().toLowerCase());
					pstmt.setString(4, registerUserData.getGender());
					pstmt.setString(5, registerUserData.getCollege());
					pstmt.setString(6, registerUserData.getCourse());

					pstmt.executeUpdate();
					pstmt.close();
					con.close();

					out.write("success");

				} else {// show UserName Already exists

					out.write("exists");
				}

			} else { // connection error
				System.out.println("problem here");
				out.write("connectionEror");
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.write("connectionEror");
		}

	}

	@Override
	public void destroy() {
		System.out.println("Destroying Servlet");
	}
}
