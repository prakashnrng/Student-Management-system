package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import com.studentportal.dao.StudentDAO;
import com.studentportal.model.Student;
  
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public SearchStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 String phone=request.getParameter("phone");
		 StudentDAO sdao=new StudentDAO();
		 Student st=null;
		 
		 try {
		 st=sdao.getStudentByPhone(phone);
		 if(st!=null) {
			 RequestDispatcher rd=request.getRequestDispatcher("searchResult.jsp");
			 request.setAttribute("STUDENT", st);
			 rd.forward(request, response);
			  
		 }else {
			 RequestDispatcher rd=request.getRequestDispatcher("searchResult.jsp");
			 request.setAttribute("NOTFOUND", true);
			 rd.forward(request, response);
			 
		 }
		 }catch(SQLException se) {
			 se.printStackTrace();
		 }
		 
		 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 
	}

}
