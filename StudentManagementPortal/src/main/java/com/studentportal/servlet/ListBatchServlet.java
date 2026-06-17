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
 
/**
 * Servlet implementation class ListBatchServlet
 */
public class ListBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BatchDAO bd=new BatchDAO();
		 String page=request.getParameter("page");
		 int pg=0;
		 if(page==null) {
			 pg=1;
		 }else {
			 pg=Integer.parseInt(page);
		 }
		 int limit=5;
		 int offset=(pg-1)*limit;
		 int btotsize=0;	 
		 //List<Batch>li=  bd.getAllBatches();
		 List<Batch>li=  bd.getAllBatches(offset,limit);
		 System.out.println("li = "+li);
		 btotsize=bd.getAllBatches();
		 int btotpage=(int)Math.ceil((double)btotsize/limit);
		 
		 if(li!=null) {
	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/listBatch.jsp");
			request.setAttribute("BATCHES", li);
			request.setAttribute("TOTAL", btotpage);
			request.setAttribute("PAGE", pg);
			
			rd.forward(request, response);
		 }else {
			 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/batchError.jsp");
				 
				rd.forward(request, response);
			 
		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
