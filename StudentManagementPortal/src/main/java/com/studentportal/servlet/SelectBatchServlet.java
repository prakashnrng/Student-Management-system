package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
 
 
@WebServlet("/SelectBatchServlet")
public class SelectBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SelectBatchServlet() {
        super();
   
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/selectBatch.jsp");
 rd.forward(request, response);
	}
 
    /*
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
  
	}
	*/

}
