package com.studentportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentportal.model.Batch;
import com.studentportal.util.DBConnection;

public class BatchDAO {

	
	public boolean addBatch(Batch b) {
		String str="insert into batch (name,timing,trainer) values(?,?,?)";
		 
		try {
Connection con=	DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement(str);
ps.setString(1, b.getName());
ps.setString(2,b.getName());
ps.setString(3, b.getTrainer());
boolean flag=ps.execute();
if(flag)return flag;

return false;
		}catch(SQLException sq) {
			sq.printStackTrace();
		}

		
		return false;
	}
	
	public boolean updateBatch(Batch ref) {
		boolean flag=false;
		String sql="update Batch set name=?,timing=?,trainer=? where id=?";
		DBConnection db=new DBConnection();
		Connection con=null;
		try {
		con=DBConnection.getConnection();
		PreparedStatement ps=  con.prepareStatement(sql);
		
		ps.setString(1, ref.getName());
		ps.setString(2, ref.getTiming());
		ps.setString(3, ref.getTrainer());
				
		ps.setInt(4, ref.getId());
		  flag=ps.execute();
		 
		
		}catch (SQLException e) {
              e.printStackTrace();
		}
		
		
		return flag;
	}
	
	public boolean deleteBatch(int id) {
		String sql="delete from batch where id=?";
		DBConnection db=new DBConnection();
Connection con=null;
boolean flag=false;
try {

con=DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement(sql);
ps.setInt(1, id);
flag=ps.execute();
 

}catch(SQLException e) {
	e.printStackTrace();
}
		
return flag;		
	}
 
	public Batch getStudentsByBatch(int batchid){
		String sql1="select * from batch where id=?";
		//String sql2="select * from Student where batch_id=?";
		Connection con=null;
		PreparedStatement ps=null;
		Batch ba=new Batch();
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql1);
			ps.setInt(1, batchid);
			ps.execute();
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ba.setId(rs.getInt(1));
				ba.setName(rs.getString(2));
				ba.setTiming(rs.getString(3));
				ba.setTrainer(rs.getString(4));
				
			}
		}catch (SQLException e) {
             e.printStackTrace();
		}
		
		
		return ba;
	}
	 
	public Batch getBatchById(int id) {
		String sql="select * from batch where id= ?";
		Connection con=null;
		PreparedStatement ps=null;
		Batch bref=new Batch();
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs=ps.getResultSet();
			if(rs.next()) {
				bref.setId(rs.getInt(1));
				bref.setName(rs.getString(2));
				bref.setTiming(rs.getString(3));
				bref.setTrainer(rs.getString(4));
				
			}
			
		}catch (SQLException e) {
             e.printStackTrace();
		}
		
		return bref;
	}
	public List<Batch> getAllBatch(){
		String sql="select * from batch"; 
		 Connection con=null;
		 int c=0;
		 List<Batch> li=new ArrayList<Batch>();
		 try {
		con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		boolean flag=ps.execute();
		ResultSet rs=ps.executeQuery();
        while(rs.next()) {
        	Batch bat=new Batch();
        			bat.setId(rs.getInt(1));
        			bat.setName(rs.getString(2));
        			bat.setTiming(rs.getString(3));
        			bat.setTrainer(rs.getString(4));
        			li.add(bat);
        	
        			
        			
        }
        }catch (SQLException e) {
        	e.printStackTrace();
			// TODO: handle exception
		}
		
		return li;
	}
	
	 public int getAllBatches(){
		 String sql="select count(*) from batch"; 
		 Connection con=null;
		 int c=0;
		 
		 try {
		con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		boolean flag=ps.execute();
		ResultSet rs=ps.getResultSet();
		if(rs.next()) {
			c=rs.getInt(1);
		}
		
			 
		 }catch (SQLException e) {
			// TODO: handle exception
		}
		 return c;
	 }
	public List<Batch> getAllBatches(int offset,int limit){
		String sql="select * from batch limit ?,?";
		List<Batch> li=new ArrayList<Batch>();
		
		//DBConnection db=new DBConnection();
        Connection con=null;
        try {
        con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, offset);
        ps.setInt(2, limit);
         
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
        	Batch bat=new Batch();
        			bat.setId(rs.getInt(1));
        			bat.setName(rs.getString(2));
        			bat.setTiming(rs.getString(3));
        			bat.setTrainer(rs.getString(4));
        			li.add(bat);
        	
        			
        			
        }
        }catch (SQLException e) {
        	e.printStackTrace();
			// TODO: handle exception
		}
		
		return li;
	}
}
