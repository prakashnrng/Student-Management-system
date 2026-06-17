package com.studentportal.dao;
import com.studentportal.util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.mindrot.jbcrypt.BCrypt;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.studentportal.model.Student;

public class StudentDAO {
	
	public int insertStudent(Student stud) throws SQLException{
		String str="insert into Student(name,email,phone,gender,dob,course,batch_id,join_date,address) values(?,?,?,?,?,?,?,?,?)";
		int val=0;
		try(Connection con=DBConnection.getConnection()){
		PreparedStatement ps=con.prepareStatement(str);
		
		ps.setString(1, stud.getName());
		ps.setString(2,stud.getEmail());
		ps.setString(3, stud.getPhone());
		ps.setString(4, stud.getGender()+"");
		ps.setDate(5, stud.getDob());
		ps.setString(6,stud.getCourse());
		ps.setInt(7, stud.getBatchid());
		ps.setDate(8,stud.getJoinDate());
		ps.setString(9, stud.getAddress());
		
		
		  val=ps.executeUpdate();
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		
			
		return val;
	}
	public List<Student> getAllStudents()throws SQLException{
		String sql="select * from Student where limit= ?";
		List<Student> li=new ArrayList<Student>();
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.execute();
		ResultSet rs= ps.getResultSet();
		int val=0;
		while(rs.next()) {
			//Student st=(Student)rs.getObject(val++);
			Student st=new Student();
			st.setId(rs.getInt(1));
			st.setName(rs.getString(2));
			st.setEmail(rs.getString(3));
			st.setPhone(rs.getString(4));
			st.setGender(rs.getString(5).charAt(0));
			st.setDob(rs.getDate(6));
			st.setCourse(rs.getString(7));
			st.setBatchid(rs.getInt(8));
			st.setJoinDate(rs.getDate(9));
			st.setAddress(rs.getString(10));
			
			li.add(st);
			 
		}
		
		return li;
	}
	//public List<Student> getStudentsByBatch(int batchid){
	public List<Student> getStudentsByBatch(int batchid,int offset,int limit){
		//jdbc doesn't support limit with place holder so use limit with concatination
		String sql="select * from Student where batch_id = ? limit ?,?";
		//String sql="select * from Student where batch_id = ? order by limit "+offset+","+limit;
		System.out.println("studentDAO = offset  = "+offset+"   limit   "+limit);
		int res=0;
		List<Student> li=new ArrayList<Student>();
		
		try(Connection con=DBConnection.getConnection()){
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, batchid);
			ps.setInt(2, offset);
			ps.setInt(3, limit);
			//ps.execute();
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 
				Student st=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),rs.getDate(6),rs.getString(7),rs.getInt(8),rs.getDate(9),rs.getString(10));
				li.add(st);
			}
			
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		return li;
		
	}
	public Student getStudentById(int id)   {
		String sql="select * from Student where student_id = ?";
		int res=0;
		Student st=new Student();
		
		try(Connection con=DBConnection.getConnection()){
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		ResultSet rs=ps.getResultSet();
		
		if(rs.next()) {
			st.setId(rs.getInt(1));
			st.setName(rs.getString(2));
			st.setEmail(rs.getString(3));
			st.setPhone(rs.getString(4));
			st.setGender(rs.getString(5).charAt(0));
			st.setDob(rs.getDate(6));
			st.setCourse(rs.getString(7));
			st.setBatchid(rs.getInt(8));
			st.setJoinDate(rs.getDate(9));
			st.setAddress(rs.getString(10));
			
		 
		}
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		
		
		return st;
	}
	
	
	public boolean updateStudent(Student stud){
		String sql="update Student set name=?,email=?,phone=?,gender=?,dob=?,course=?,batch_id=?,join_date=?,address=? where student_id= ?";
		int res=0;
		try(Connection con=DBConnection.getConnection()){
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, stud.getName());
		ps.setString(2,stud.getEmail());
		ps.setString(3, stud.getPhone());
		ps.setString(4, stud.getGender()+"");
		ps.setDate(5, stud.getDob());
		ps.setString(6,stud.getCourse());
		ps.setInt(7, stud.getBatchid());
		ps.setDate(8,stud.getJoinDate());
		ps.setString(9, stud.getAddress());
		ps.setInt(10, stud.getId());
		res=ps.executeUpdate();
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		 
		return res>0;
	}
	
	public boolean deleteStudent(int id) throws SQLException{
		String sql="delete from student where student_id= ?";
		int res=0;
		try(Connection con=DBConnection.getConnection()){
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		  res=ps.executeUpdate();
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		
		return res>0;
		
	}

	public int getTotalStudents()throws SQLException{
		String sql="select count(*) from student";
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
         boolean flag= ps.execute();
          ResultSet rs=ps.getResultSet();
    
    int c=0;
    if(rs.next()) {
    c=rs.getInt(1);
    System.out.println("c = "+c);
    }
   
	return c;
 
	}
	
public Student	getStudentByPhone(String phone)throws SQLException{
	String sql="select * from student where phone=?";
	DBConnection db=new DBConnection();
	Connection con=db.getConnection();
	 PreparedStatement ps=null;
	 Student st=new Student();
	 try {
		 ps=con.prepareStatement(sql);
		 ps.setString(1, phone);
		 boolean flag=ps.execute();
		 if(!flag) {
			 return null;
		 }
		 ResultSet rs=ps.getResultSet();
		  
		 
		 while(rs.next()) {
			 st.setId(rs.getInt(1));
			 st.setName(rs.getString(2));
			 st.setEmail(rs.getString(3));
			 st.setPhone(rs.getString(4));
			 st.setGender(rs.getString(5).charAt(0));
			 st.setDob(rs.getDate(6));
			 st.setBatchid(rs.getInt(7));
			 st.setJoinDate(rs.getDate(8));
			 st.setAddress(rs.getString(9));
			 			 		 
		 }
		 
	 }catch (SQLException e) {
           e.printStackTrace();
	}
		
	return st;
	}


public List<Student> getStudentsByEmail(String email,int batchid,int page,int offset) {
	String sql="select * from student where email=? and batch_id = ?   limit ?,?";
	 System.out.println("email = "+email+" batchid = "+batchid+" page = "+page);
	List<Student> li=new ArrayList<Student>();
	try(Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);	
			) {
	ps.setString(1,email);
	ps.setInt(2, batchid);
	ps.setInt(3, page);
	ps.setInt(4, offset);
	ResultSet rs= ps.executeQuery();
	while(rs.next()) {
	Student	  st=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),rs.getDate(6),rs.getString(7),rs.getInt(8),rs.getDate(9),rs.getString(10));
	li.add(st);
		
	}
	}catch (SQLException e) {
		// TODO: handle exception
	}
	return li;
}


public int getStudentsByPage(int batchid)throws SQLException  {
	String sql="select count(*) from student  where batch_id = ?";
	//DBConnection db=new DBConnection();
	
	Connection con=null;
	List<Student> li=null;
	try {
	con= DBConnection.getConnection();
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, batchid);
ResultSet rs=ps.executeQuery();
if(rs.next()) {
	return rs.getInt(1);
}

	}catch (SQLException e) {
	e.printStackTrace();
	}
	
	return 0;
	
}


public List<Student> getStudentsByPage(int offset,int limit)throws SQLException  {
	String sql="select * from student  limit ?,?";
	//DBConnection db=new DBConnection();
	
	Connection con=null;
	List<Student> li=null;
	try {
	con= DBConnection.getConnection();
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, offset);
	ps.setInt(2, limit);
	boolean flag=ps.execute();
	if(!flag) {
		return null;
	}
	ResultSet rs=ps.getResultSet();
	  li=new ArrayList<Student>();
	while(rs.next()) {
		
		Student st=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),rs.getDate(6),rs.getString(7),rs.getInt(8),rs.getDate(9),rs.getString(10));
		li.add(st);
   		
	}
	  
	
	}catch (SQLException e) {
		e.printStackTrace();
 
	}
	
	
	
	
	return li;
}
public List<Student> getStudentsByPhone(String phone, int batchid, int offset, int limit) {
     String query="select * from Student where phone=? and batch_id=? limit ?,?";
     List<Student> li=new ArrayList<Student>();
     
     try(Connection con=DBConnection.getConnection();
    		 PreparedStatement ps=con.prepareStatement(query)){
    	 ps.setString(1, phone);
    	 ps.setInt(2, batchid);
    	 ps.setInt(3, offset);
    	 ps.setInt(4, limit);
    	 ResultSet rs=ps.executeQuery();
    	 while(rs.next()) {
    		 Student st=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),rs.getDate(6),rs.getString(7),rs.getInt(8),rs.getDate(9),rs.getString(10));
             li.add(st);    		 
    	 }
    	 
     }catch (SQLException e) {
          e.printStackTrace();
	}
	return li;
}
public List<Student> getStudentsByName(String name, int batchid, int offset, int limit) {
	String query="select * from Student where name=? and batch_id=? limit ?,?";
    List<Student> li=new ArrayList<Student>();
    
    try(Connection con=DBConnection.getConnection();
   		 PreparedStatement ps=con.prepareStatement(query)){
   	 ps.setString(1, name);
   	 ps.setInt(2, batchid);
   	 ps.setInt(3, offset);
   	 ps.setInt(4, limit);
   	 ResultSet rs=ps.executeQuery();
   	 while(rs.next()) {
   		 Student st=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),rs.getDate(6),rs.getString(7),rs.getInt(8),rs.getDate(9),rs.getString(10));
            li.add(st);    		 
   	 }
   	 
    }catch (SQLException e) {
         e.printStackTrace();
	}
	return li;
}
public int getTotalByEmail(String email,int batchid) {
	String query="select count(*) from Student where email=? and batch_id=?";
     
    int c=0;
    try(Connection con=DBConnection.getConnection();
   		 PreparedStatement ps=con.prepareStatement(query)){
   	 ps.setString(1, email);
   	 ps.setInt(2, batchid);
   	  
   	 
   	 ResultSet rs=ps.executeQuery();
   	 if(rs.next()) {
   		 c=rs.getInt(1);    		 
   	 }
   	 
    }catch (SQLException e) {
         e.printStackTrace();
	}
	return c;

 
	 
}
public int getTotalByPhone(String phone, int batchid) {
	String query="select count(*) from Student where phone=? and batch_id=?";
    
    int c=0;
    try(Connection con=DBConnection.getConnection();
   		 PreparedStatement ps=con.prepareStatement(query)){
   	 ps.setString(1, phone);
   	 ps.setInt(2, batchid);
   	  
   	 
   	 ResultSet rs=ps.executeQuery();
   	 if(rs.next()) {
   		 c=rs.getInt(1);    		 
   	 }
   	 
    }catch (SQLException e) {
         e.printStackTrace();
	}
	return c;

  
}
public int getTotalByName(String name, int batchid) {
String query="select count(*) from Student where name=? and batch_id=?";
    
    int c=0;
    try(Connection con=DBConnection.getConnection();
   		 PreparedStatement ps=con.prepareStatement(query)){
   	 ps.setString(1, name);
   	 ps.setInt(2, batchid);
   	  
   	 
   	 ResultSet rs=ps.executeQuery();
   	 if(rs.next()) {
   		 c=rs.getInt(1);    		 
   	 }
   	 
    }catch (SQLException e) {
         e.printStackTrace();
	}
	return c;


	 
	 
}
public Student loginInputEmail(String email, String pwd) {
	//String sql="select * from student where email=? and pwd=?";
	String sql="select * from student where email=?";
	Student st=null;
	try(Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);){
		ps.setString(1, email);
		ResultSet rs= ps.executeQuery();
		String status="";
		String pw="";
		
		if(rs.next()) {
			 
			 st=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),rs.getDate(6),rs.getString(7),rs.getInt(8),rs.getDate(9),rs.getString(10),rs.getString(11),rs.getString(12));
			 status=rs.getString(12);
				//em=rs.getString(3);
			pw=rs.getString(11);
			if(!BCrypt.checkpw(pwd,pw)) {////we need to compare palin password with hashpassword
				return st;
			}
		//}
		if(!status.equalsIgnoreCase("active")) {
			return null;
			
		}
		}
			
			
		
	}catch(SQLException sq) {
		sq.printStackTrace();
	}
	
	
	return st;
	 
	
}

public Student loginInputPhone(String phone, String pwd) {
	//String sql="select * from student where phone=? and pwd=?";
	String sql="select * from student where phone=?";
	Student st=null;
	try(Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);){
		ps.setString(1, phone);
		ResultSet rs= ps.executeQuery();
		String status="";
		String paswd="";
		if(rs.next()) {
			 st=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),rs.getDate(6),rs.getString(7),rs.getInt(8),rs.getDate(9),rs.getString(10),rs.getString(11),rs.getString(12));
			 paswd=rs.getString(11); 
				status=rs.getString(12);
				if(!BCrypt.checkpw(pwd, paswd)) {//we need to compare palin with hashpwd
					return null;
				}
				if(!status.equalsIgnoreCase("active")) {
					return null;
					
				}
		}
             
			//boolean flag=BCrypt.checkpw(pwd, paswd);
		
			
		//}
		
		
	}catch(SQLException sq) {
		sq.printStackTrace();
	}
	
	
	return st;
	 
	
}
public boolean insertStudent_login_log(int id, Timestamp forDateTime, String ipAddr) {
	 String sql="insert into student_login_log(student_id,login_time,ip_address) values(?,?,?)";
	try {
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setTimestamp(2, forDateTime);
		ps.setString(3, ipAddr);
		boolean flag=ps.execute();
		return flag;
		
	}catch (SQLException e) {
 e.printStackTrace();
	}
	return false;
}
}
