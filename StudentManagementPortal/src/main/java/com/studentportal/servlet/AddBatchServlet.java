package com.studentportal.servlet;

import java.io.IOException;
import java.util.List;

import com.studentportal.dao.BatchDAO;
import com.studentportal.model.Batch;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBatchServlet extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("addBatchServlet");
		
		  RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/addBatch.jsp");
		  
		  rd.forward(request, response);
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	  
		
		
	}



}
