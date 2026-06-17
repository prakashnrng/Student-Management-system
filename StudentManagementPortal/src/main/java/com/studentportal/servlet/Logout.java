package com.studentportal.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
 
 
@WebServlet("/student/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public Logout() {
        super();
       
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LogOut servlet");
 HttpSession ses=request.getSession(false);
 if(ses!=null) {
	 ses.invalidate();
 }
//Prevent browser back-button from showing cached dashboard
 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
 response.setHeader("Pragma", "no-cache");
 response.setDateHeader("Expires", 0);
 response.sendRedirect(request.getContextPath()+"/student/login.jsp");
	}
 
 

}
