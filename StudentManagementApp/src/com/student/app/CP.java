package com.student.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
	 
	static Connection con;

	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		//load the driver
		Class.forName("com.mysql.jdbc.Driver");
		// create the connection 
		String url="jdbc:mysql://localhost:3306/student_manage";
		String username="root";
		String password="root";
		con=DriverManager.getConnection(url,username,password);
		return con;
	}
}
