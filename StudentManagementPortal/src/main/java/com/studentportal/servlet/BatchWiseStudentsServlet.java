package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.studentportal.dao.BatchDAO;
import com.studentportal.dao.StudentDAO;
import com.studentportal.model.Batch;
import com.studentportal.model.Student;
  



@WebServlet("/admin/BatchWiseStudentsServlet")
public class BatchWiseStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BatchWiseStudentsServlet() {
        super();
         
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 int pg=1;
 String keyword=request.getParameter("keyword");
 
// System.out.println("batchid = "+batchid+" page = "+page);
 int batchid=Integer.parseInt(request.getParameter("id"));
 BatchDAO bda=new BatchDAO();
 StudentDAO sda=new StudentDAO();
  Batch ba= bda.getBatchById(batchid);
  int limit=5;
    //int offset=(pg-1)*limit;
  int offset=0;
   int total=0;
   List<Student> li=null;

		 
		 String  page=request.getParameter("page");
 boolean isAjax="XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

 
		 
		 try {
		 if(page!=null) {
				 
					 pg=Integer.parseInt(request.getParameter("page"));
					 System.out.println("else else block  pg = "+pg);
					 
				 }
		 }catch(NumberFormatException ne) {
			 ne.printStackTrace();
		 }
			if(pg<1) {
				pg=1;
			}
		//String  page=Integer.parseInt(request.getParameter("page"));
			offset=(pg-1)*limit;
	if(keyword==null||keyword.trim().isEmpty()) {	 
				    
		    li= sda.getStudentsByBatch(batchid,offset,limit);
		  System.out.println("BatchWiseServlet =  "+li);
		  try {
			    total=sda.getStudentsByPage(batchid);
			  }catch (SQLException e) {
				e.printStackTrace();
			}
		   	}else {
		 		System.out.println("else block  pg = "+pg);
		// 		char digit[]=new char[10];
		 		int i=0;
		 		char carr[]=keyword.toCharArray();
		 		
		 		for(i=0;i<carr.length;i++) {
		 			if(!(carr[i]>=48 && carr[i]<=57)) {
		 //			digit[carr[i]-'0']++;
		 	 
		 				break;
		 			}
		 			
		 		}
		 		 
		 		if(keyword.contains("@")) {
		 			
		 			li= sda.getStudentsByEmail(keyword,batchid,offset,limit);
		 			total=sda.getTotalByEmail(keyword,batchid);
		 		}else if(i==carr.length) {
		 			String phone=keyword; 
		 			li= sda.getStudentsByPhone(phone,batchid,offset,limit);
		 			total=sda.getTotalByPhone(phone,batchid);
		 		}else {
		 			String name=keyword; 
		 			li= sda.getStudentsByName(name,batchid,offset,limit);
		 			total=sda.getTotalByName(name,batchid);
		 			
		 		}
		      //li= sda.getStudentsByEmail(keyword,batchid,offset,limit);
		  System.out.println("BatchWiseServlet =  "+li);
		 	
	}
	  
		  int totpage=(int)Math.ceil((double)(total)/limit);
 
	  
	  request.setAttribute("STUDENTS", li);
	  request.setAttribute("BATCH", ba);
	  request.setAttribute("PAGE", pg);
	  request.setAttribute("TOTPAGE", totpage);
	  request.setAttribute("KEYWORD", keyword);
 

	  
	  
	  if(isAjax) {
 System.out.println("BatchWiseServlet -> if(isAjax)");
			 request.getRequestDispatcher("/WEB-INF/views/batchWiseStudentsTable.jsp").forward(request, response);
			 
			 
		 }else {
			 request.getRequestDispatcher("/WEB-INF/views/batchWiseStudents.jsp").forward(request, response);
		 }
	  
	  
	}

 
 

}
