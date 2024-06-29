package com.servletpractice;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	Connection getConnection () {
		try {
			String url = "jdbc:mysql://localhost:3306/demodb";
			String name = "root";
			String pass = "root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,name,pass);
			System.out.println("Success");
			return con;
		} catch (Exception e) {
			System.out.println("Can't connect to db");
//			e.printStackTrace();
			return null;
		}
	}
}
