package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import com.studentportal.dao.StudentDAO;
 
 @WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public HomeServlet() {
        super();
   
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		 StudentDAO std=new StudentDAO();
		 int count=0;
		 try {
           count=std.getTotalStudents();

           RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
           request.setAttribute("total", count);
           rd.forward(request, response);
          
          
		 }catch (SQLException e) {
              e.printStackTrace();
		}
	}

 	 

}
