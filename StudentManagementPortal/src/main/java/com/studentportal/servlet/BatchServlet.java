package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.studentportal.dao.BatchDAO;
import com.studentportal.model.Batch;
 
 
@WebServlet("/BatchServlet")
public class BatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String name=request.getParameter("name");
				String timing=request.getParameter("timing");
				String trainer=request.getParameter("trainer");
		Batch bt=new Batch(name,timing,trainer);
				BatchDAO bd=new BatchDAO();
				boolean flag=bd.addBatch(bt);
				//RequestDispatcher rd=request.getRequestDispatcher("ListBatchServlet");
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
				  rd.forward(request, response);
				  
				  
 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
 
	}

}
