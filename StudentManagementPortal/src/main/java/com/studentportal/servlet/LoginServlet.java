package com.studentportal.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.studentportal.dao.AdminDao;
  
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("password");
		AdminDao adm=new AdminDao();
		boolean flag=adm.validateLogin(uname, pwd);
		String str="";
		RequestDispatcher rd=null;
		if(flag) {
			 
			HttpSession ses=request.getSession();
			rd=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			//String role=(String)ses.getAttribute("ROLE");
//			ses.setAttribute("ADMIN", true);
			ses.setAttribute("username", uname);
			//ses.setAttribute("role", role);
			ses.setAttribute("ROLE", "ADMIN");
			//ses.setAttribute("ADMIN", "admin");
			ses.setMaxInactiveInterval(50*60);
			rd.forward(request, response);

			
		}else {
			 
			rd=request.getRequestDispatcher("login.jsp");
			request.setAttribute("TRUE", "true");
			rd.forward(request, response);
		}

		


 
		
		
		
	}

}
