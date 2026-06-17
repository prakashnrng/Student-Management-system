package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentportal.dao.BatchDAO;
import com.studentportal.dao.StudentDAO;
import com.studentportal.model.Batch;
import com.studentportal.model.Student;
 

 
public class ListStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListStudentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
 		StudentDAO sda=new StudentDAO();
		String pa=request.getParameter("page");
		int page=0;
		if(pa==null) {
			page=1;
		}else {
		  page=Integer.parseInt(request.getParameter("page"));
		}
		int limit=5;
		int offset=(page-1)*limit;
		List<Student> li=null;
		List<Batch> lref=null;
		int totsize=0;
		
		try {
		//li=sda.getAllStudents();
		//totsize=li.size();
			
			li=sda.getStudentsByPage(offset,limit);
			BatchDAO bd=new BatchDAO();
			
			 lref=  bd.getAllBatches(offset,limit);
			System.out.println("lref = "+lref);
			
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		
		try {
		totsize=sda.getTotalStudents();
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		
		int totpages=(int)Math.ceil((double)totsize/limit);
		request.setAttribute("students", li);
		request.setAttribute("TOTAL", totpages);
		request.setAttribute("BATCHES", lref);
		request.setAttribute("PAGE", page);
				 
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/listStudents.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
