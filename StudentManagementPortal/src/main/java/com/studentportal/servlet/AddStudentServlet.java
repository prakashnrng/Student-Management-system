package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.studentportal.dao.BatchDAO;
import com.studentportal.model.Batch;
 
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public AddStudentServlet() {
        super();
         }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BatchDAO bd=new BatchDAO();
		 List<Batch>li=  bd.getAllBatch();
		 System.out.println("li = "+li);
		 if(li!=null) {
	// 
			 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/addstudent.jsp");
			request.setAttribute("BATCHES", li);
			rd.forward(request, response);
		//	rd.forward(request, response);
		 }else {
			  RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/batchError.jsp");
				 
				rd.forward(request, response);
			 
		 }
		
	 
	 
	  
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
