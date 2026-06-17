package com.studentportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.studentportal.util.DBConnection;

public class AdminDao {
	
	
public boolean validateLogin(String uname,String pwd) {
	//String sql="select password from users where username=? and password=?";
	String sql="select * from users where username=?";
	DBConnection db=new DBConnection();
	Connection con=null;
	boolean flag=false;
	System.out.println("uname = "+uname+"  pwd   "+pwd);
	try {
		con=db.getConnection();
		PreparedStatement ps=  con.prepareStatement(sql);
		ps.setString(1, uname);
		//ps.setString(2, pwd);
		 
		ResultSet rs=ps.executeQuery();
		 if(rs.next()) {
			String hashedpwd=rs.getString("password");
			flag=BCrypt.checkpw(pwd, hashedpwd);
			  
		 }
		System.out.println("flag = "+flag);
	}catch (SQLException e) {
 e.printStackTrace();
	}
	
	
	return flag;
}
}
