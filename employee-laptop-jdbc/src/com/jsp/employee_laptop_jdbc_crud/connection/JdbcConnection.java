package com.jsp.employee_laptop_jdbc_crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcConnection {
public static Connection getConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/employee_laptop_jdbc";
		String user="root";
		String pass="shubhi@123";
		
		return DriverManager.getConnection(url,user,pass);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
}
