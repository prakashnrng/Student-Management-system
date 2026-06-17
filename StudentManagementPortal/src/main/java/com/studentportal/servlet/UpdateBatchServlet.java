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
 * Servlet implementation class UpdateBatchServlet
 */
public class UpdateBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBatchServlet() {
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
		 
		 int  id=Integer.parseInt(request.getParameter("id"));
		 String name=request.getParameter("name");
		 String timing=request.getParameter("timing");
		 String trainer=request.getParameter("trainer");
		 Batch ba=new Batch(id,name,timing,trainer);
		 System.out.println("updateBatchServlet ba = "+ba);
		 BatchDAO bd=new BatchDAO();
		 boolean flag=bd.updateBatch(ba);
		 System.out.println("flag = "+flag);
		 //RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/viewBatches.jsp");
		 //RequestDispatcher rd=request.getRequestDispatcher("ListBatchServlet");
		 //rd.forward(request, response);
		 response.sendRedirect("admin/ListBatchServlet");
		 
		 
		 
	}

}
