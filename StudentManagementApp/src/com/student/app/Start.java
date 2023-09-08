package com.student.app;

import java.sql.SQLException;
import java.util.Scanner;

public class Start {
public static void main(String args[]) throws ClassNotFoundException, SQLException {
	System.out.println("hi");
	
	Scanner sc = new Scanner(System.in);
	while(true) {
		System.out.println("PRESS 1 to ADD student");
		System.out.println("PRESS 2 to DELETE student");
		System.out.println("PRESS 3 to DISPLAY student");
		System.out.println("PRESS 4 to EXIT app");
		
		int num=sc.nextInt();
		
		if(num==1) {
			System.out.println("Enter the username");
			String name= sc.next();
			System.out.println("Enter the phone number");
			int phone = sc.nextInt();
			System.out.println("Enter user City");
			String city= sc.next();
			
			// create student object to store student
			Student st=new Student(name, phone, city);
			boolean ans= StudentDao.insertStudentToDao(st);
			if(ans==true) {
				System.out.println("success fully added in the database");
			}
			else {
				System.out.println("not added in the database something went wrong");
			}
			System.out.println(st);
		}
		else if(num==2) {
			// delete student
		}
		else if(num==3) {
			// display student
		}
		else if (num==4){
			// exit app
		 break; 
		}
		else {
			
		}
	}
	System.out.println("Thanku for using my application");
}
}
