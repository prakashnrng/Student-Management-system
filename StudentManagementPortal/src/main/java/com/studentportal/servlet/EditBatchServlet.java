package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.studentportal.dao.BatchDAO;
import com.studentportal.model.Batch;
 
/**
 * Servlet implementation class EditBatchServlet
 */
public class EditBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("EDIT Batch Servlet do post()");
		 int id=Integer.parseInt(request.getParameter("id"));
		 System.out.println("id = "+id);
		 BatchDAO btd=new BatchDAO();
		 Batch bth=btd.getBatchById(id);
		 System.out.println("btch = "+bth);
		 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/editBatch.jsp");
		 request.setAttribute("BATCH", bth);
		 rd.forward(request, response);
		 
	}

}
