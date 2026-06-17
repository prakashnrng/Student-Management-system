package com.studentportal.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class StudentAuthFilter implements Filter{

 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
 		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    HttpSession ses = req.getSession(false); 

	    // 1. Get the current path relative to the web app root
	    String path = req.getServletPath(); 
	    System.out.println("Filter checking path: " + path);

	    // 2. Define allowed paths (no login required)
	    boolean isLoginPage = path.equals("/student/login.jsp");
	    boolean isLoginServlet = path.equals("/student/StudentLoginServlet");
	    
	    // 3. Check for specific session attributes
	    boolean loggedIn = (ses != null && ses.getAttribute("NAME") != null);
        boolean logout=path.endsWith("/student/Logout");
	    if (loggedIn || isLoginPage || isLoginServlet||logout) {
	        System.out.println("Access Granted to: " + path);
	        chain.doFilter(request, response);
	    } else {
	        System.out.println("Access Denied! Redirecting to login. Context: " + req.getContextPath());
	        res.sendRedirect(req.getContextPath() + "/student/login.jsp");
	    }
	}	    
	
	 
 		
	}
	

	 