package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.studentportal.dao.BatchDAO;
import com.studentportal.dao.StudentDAO;
import com.studentportal.model.Batch;
import com.studentportal.model.Student;
 

 
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditStudentServlet() {
        super();
  
    }

 	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 		int id=Integer.parseInt(req.getParameter("id"));
 		System.out.println("id = "+id);
		StudentDAO sda=new StudentDAO();
		Student st=sda.getStudentById(id);
		req.setAttribute("student", st);
		 BatchDAO bd=new BatchDAO();
		 List<Batch>li=  bd.getAllBatch();
		 System.out.println("li = "+li);
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/edit_student.jsp");
		req.setAttribute("BATCHES", li);
		rd.forward(req, res);
		 
	}

 	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		char gender=req.getParameter("gender").charAt(0);
		String course=req.getParameter("course");
		String dbrth=req.getParameter("dob");
		java.sql.Date dob=java.sql.Date.valueOf(dbrth);
		System.out.println("dbrth= "+dbrth);
		System.out.println("dob= "+dob);
		String join_dat=req.getParameter("join_date");//its not in YYYY-MM-dd
		SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
		 System.out.println("join_dat - "+join_dat);
		java.sql.Date join_date=null;
		try {
			Date utildate=form.parse(join_dat);
			
			 join_date=new java.sql.Date(utildate.getTime());
			 
			
		}catch (ParseException e) {
			e.printStackTrace();
 
		}
		
		 System.out.println("join_date - "+join_date);
		 /*
		  * 
		  */
		 
		 
		 /*
		  * 
		  * 
		  * 
		  */
		int batchid=Integer.parseInt(req.getParameter("batch_id"));
		String address=req.getParameter("address");
		
		Student st=new Student(id,name,email,phone,gender,dob,course,batchid,join_date,address);
		
		StudentDAO sda=new StudentDAO();
		boolean flag=false;
		flag=sda.updateStudent(st);
		
		res.sendRedirect(req.getContextPath()+"/admin/ListStudentsServlet");
	}

}
