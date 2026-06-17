package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.studentportal.dao.BatchDAO;
 
/**
 * Servlet implementation class DeleteBatchServlet
 */
public class DeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id=Integer.parseInt(request.getParameter("id"));
		 BatchDAO bda=new BatchDAO();
		 boolean flag=bda.deleteBatch(id);
		 //RequestDispatcher rd=request.getRequestDispatcher("ListBatchServlet");
		 //rd.forward(request, response);
		 System.out.println("flag = "+flag);
		 response.sendRedirect("ListBatchServlet");
 

		
		
	}

}
