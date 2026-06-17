package com.studentportal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static final String URL="jdbc:mysql://localhost:3306/student_management_portal?useSSL=false&serverTimezone=UTC";
	public static final String USER="root";
	public static final String PASSWORD="7396";
static {
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException ce) {
		ce.printStackTrace();
	}
}
public static Connection getConnection() throws SQLException{
	Connection con=null;
	 try {
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/student_management_portal?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
		            "root",
		            "7396"
		        );
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return con;
 
 
	 
}



}
