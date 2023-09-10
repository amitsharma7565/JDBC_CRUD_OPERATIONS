package com.student.app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertStudentToDao(Student st) throws ClassNotFoundException, SQLException {
		boolean f=false;
		Connection con=CP.createConnection();
		String sq="insert into student(sname,sphone,scity)values (?,?,?)";
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

	public static boolean deleteStudent(int userId) throws ClassNotFoundException, SQLException {
		boolean f=false;
		Connection con=CP.createConnection();
		String sq="delete from student where sid=?";
		//  user prepared statement
	 PreparedStatement pstmt=	con.prepareStatement(sq);
		// set the value of parameters in ?
	 pstmt.setInt(1, userId);
	 // excute query
	 pstmt.executeUpdate();
	 f=true;
	 if(f) {
		 System.out.println("deletes sucessfully");
	 }
	 else {
		 System.out.println("not delete please check again ");
	 }
	return f; 
		
	}

	public static void showAllStudent() throws ClassNotFoundException, SQLException {
		boolean f=false;
		Connection con=CP.createConnection();
		String sq="select*from student";
	Statement stmt= con.createStatement();
//	if you want to fetch the result then use exceuteQuery and it return collection of object thats why it store in resultset
	 ResultSet st=stmt.executeQuery(sq);
	 while(st.next()) {
		 int id= st.getInt(1);
		 String name=st.getString(2);
		 int phone =st.getInt(3);
		 String city= st.getString(4);
//		 print all the details
		 System.out.println("ID "+id);
		 System.out.println("Name "+name);
		 System.out.println("Phone "+phone);
		 System.out.println("City "+city);
		 System.out.println("+++++++++++++++++++++");
	 }
	}

	public static void updateStudent(int id,String newName) throws ClassNotFoundException, SQLException {
		boolean f=false;
		Connection con=CP.createConnection();
		String sq="update student set sname =? where sid=?";
		//  user prepared statement
	 PreparedStatement pstmt=	con.prepareStatement(sq);
		// set the value of parameters in ?,?,?
	 pstmt.setString(1,newName);
	 pstmt.setInt(2, id);
	 // excute query
	 pstmt.executeUpdate();
	 f=true;
	if(f) {
		System.out.println("its updated sucessFully");
	}
	else {
		System.out.println("not updated");
	}
	}
}
