package com.student.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {

	public static boolean insertStudentToDao(Student st) throws ClassNotFoundException, SQLException {
		boolean f=false;
		Connection con=CP.createConnection();
		String sq="insert into student vaules(?,?,?)" ;
		//  user prepared statement
	 PreparedStatement pstmt=	con.prepareStatement(sq);
		// set the value of parameters in ?,?,?
	 
	 pstmt.setString(1, st.getStudentName());
	 pstmt.setInt(2, st.getStudentPhone());
	 pstmt.setString(3, st.getStudentCity());
	 
	 // excute query
	 pstmt.executeUpdate();
	 f=true;
	return f; 
	}
}
