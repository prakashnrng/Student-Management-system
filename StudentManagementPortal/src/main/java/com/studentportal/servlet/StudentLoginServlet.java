package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.studentportal.dao.StudentDAO;
import com.studentportal.model.Student;
 /**
 * Servlet implementation class StudentLoginServlet
 */

 
@WebServlet("/student/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentLoginServlet() {
        super();
     
    }

	/*
	 * protected void doGet(HttpServletRequest req, HttpServletResponse res) throws
	 * ServletException, IOException {
	 * System.out.println("StudentLoginServlet  doGet  "); //RequestDispatcher
	 * rd=req.getRequestDispatcher("/student/login.jsp"); //rd.forward(req, res);
	 * 
	 * res.sendRedirect(req.getContextPath()+"/student/login.jsp");
	 * 
	 * }
	 */

	 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("StudentLoginServlet  doPost  ");
		String keyword=req.getParameter("keyword");
		String pwd=req.getParameter("pwd");
		HttpSession ses=null;
		StudentDAO sd=new StudentDAO();
		Student st=null;
		
		if(keyword!=null && pwd!=null) {
			int len=keyword.length();
			if(keyword.contains("@")) {
				String email=keyword;
				st=sd.loginInputEmail(email,pwd);
			}else if (keyword.matches("\\d{10}")) {
                st = sd.loginInputPhone(keyword, pwd);
			}  else {
        			req.setAttribute("ERROR", "invalid user or password");
        			 req.getRequestDispatcher("/student/login.jsp").forward(req, res);
        			//res.sendRedirect(req.getContextPath()+"/student/login.jsp");
        			return;
        		}
            
			
			
			/*
			 * {
				 int i=0;
				 char carr[]=keyword.toCharArray();
				 
				 while(i<len&&len==10) {
					 if(!(carr[i]>=48 && carr[i]<=57)) {
						 
						RequestDispatcher rd= req.getRequestDispatcher("/student/loginerr.jsp");
						rd.forward(req, res);
					 }
					 i++;
				 }
				 String ph=keyword;
				 st= sd.loginInputPhone(ph,pwd);
			}
			*/
		}

		
		if(st!=null) {
			System.out.println("st!=null"+st);
			ses=req.getSession();
			ses.setAttribute("NAME", st.getName());
			ses.setAttribute("SID", st.getId());
			ses.setAttribute("BID", st.getBatchid());
			ses.setAttribute("ROLE", "STUDENT");
			String ipAddr=req.getRemoteAddr();
			LocalDateTime now=LocalDateTime.now();
			//DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			//String forDateTime=now.format(dtf);
			//java.sql.Date curdate=java.sql.Date.valueOf(forDateTime);
			Timestamp sqltimeStamp=Timestamp.valueOf(now);
			
			String forwrd=req.getHeader("X-Forwarded-For");
			if(forwrd!=null) {
				ipAddr=forwrd.split(",")[0];
			}
			//sd.insertStudent_login_log(st.getName(),st.getId(),forDateTime,ipAddr);
			sd.insertStudent_login_log(st.getId(),sqltimeStamp,ipAddr);
			//req.getRequestDispatcher("/student/dashboard.jsp").forward(req, res);
			res.sendRedirect(req.getContextPath()+"/student/dashboard.jsp");
			
			
		}else {
			req.setAttribute("ERROR", "invalid user or password");
			req.getRequestDispatcher("/student/login.jsp").forward(req, res);
			//res.sendRedirect(req.getContextPath()+"/student/login.jsp");
			System.out.println("-----------if else---------------------");
			return;
		}
	  
		/*
		System.out.println("Session NAME: " + ses.getAttribute("NAME"));
		System.out.println("Session SID: " + ses.getAttribute("SID"));
		System.out.println("Session BID: " + ses.getAttribute("BID"));
		*/
		
		
	 
	}

}
