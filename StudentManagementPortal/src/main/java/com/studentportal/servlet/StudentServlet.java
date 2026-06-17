package com.studentportal.servlet;

 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.studentportal.dao.StudentDAO;
import com.studentportal.model.Student;
import com.studentportal.util.DBConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void search(HttpServletRequest req,HttpServletResponse res)throws ServletException{
		String phone=req.getParameter("phone");
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws  ServletException, IOException {
	 
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		char gender=req.getParameter("gender").charAt(0);
		String course=req.getParameter("course");
		String dbrth=req.getParameter("dob");
		java.sql.Date dob=java.sql.Date.valueOf(dbrth);
		String join_dat=req.getParameter("join_date");
		java.sql.Date join_date=java.sql.Date.valueOf(join_dat); 
		int batchid=Integer.parseInt(req.getParameter("batch_id"));
		String address=req.getParameter("address");
		
		Student st=new Student(name,email,phone,gender,dob,course,batchid,join_date,address);
		
		 StudentDAO std=new StudentDAO();
		 int reslt=0;
		 try {
		 reslt=std.insertStudent(st);
		 
		 }catch(SQLException sql) {
			 sql.printStackTrace();
		 }
		 
		 PrintWriter out=res.getWriter();
		 
		 if(reslt>0) {
//			 out.println("<h3 style='color:green'>Student added successfully!</h3>");
			 req.setAttribute("message", "Student details updated successfully!");
RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/success.jsp");
rd.forward(req, res);
		 }else {
			 //out.println("<h3 style='color:red'>Failed to add student</h3>");
		req.setAttribute("message", "failed to update Student details");
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/error.jsp");
		rd.forward(req, res);
		 }
		 
		 out.close();
		 
		
	}

}
