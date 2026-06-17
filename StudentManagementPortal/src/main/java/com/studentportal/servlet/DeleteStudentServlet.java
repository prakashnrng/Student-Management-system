package com.studentportal.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;

import com.studentportal.dao.StudentDAO;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class DeleteStudentServlet
 */
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 StudentDAO sdo=new StudentDAO();
		 int id=Integer.parseInt(req.getParameter("id"));
		 boolean flag=false;
		 try {
		 flag=sdo.deleteStudent(id);
		 }catch(SQLException sq) {
			 sq.printStackTrace();
		 }
		 res.sendRedirect("ListStudentsServlet");//it will fetch the data from database
		 //and then display the data to the user

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
