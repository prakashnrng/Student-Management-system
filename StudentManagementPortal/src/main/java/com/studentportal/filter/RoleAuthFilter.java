package com.studentportal.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
  
//@WebFilter("/RoleAuthFilter")

public class RoleAuthFilter implements Filter {
     public RoleAuthFilter() {
        super();
  
    }

	 
	public void destroy() {
	 
	}

	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	 System.out.println("RoleAuthFIlter");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession ses=req.getSession(false);
		String uri=req.getRequestURI();
		System.out.println("RoleAuth filter uri = "+req.getRequestURI());
		//if(ses==null||!ses.getAttribute("ROLE").equals("ADMIN")) {
		if(ses==null) {
			System.out.println("ses==null");
			res.sendRedirect(req.getContextPath()+"/login.jsp");
			return;
		}
		String role=(String)ses.getAttribute("ROLE");
		if(uri.startsWith(req.getContextPath()+"/student/")&&role==null) {
			System.out.println("uri.startsWith(req.getContextPath()+\"/student/\")&&role.equals(\"STUDENT\")");
			chain.doFilter(request, response);
		return;	
		}

		if(uri.startsWith(req.getContextPath()+"/student/")&&role.equals("STUDENT")) {
			System.out.println("uri.startsWith(req.getContextPath()+\"/student/\")&&role.equals(\"STUDENT\")");
			chain.doFilter(request, response);
		return;	
		}
		 
		//if(uri.startsWith(req.getContextPath()+"/WEB-INF/views/")&&role.equals("ADMIN")) {
		if(uri.startsWith(req.getContextPath()+"/admin/")&&role.equals("ADMIN")) {
			System.out.println("uri.startsWith(req.getContextPath()+\"/admin/\")&&role.equals(\"ADMIN\")");
			chain.doFilter(request, response);
			return;
		}
		/*
		if(uri.startsWith(req.getContextPath()+"/WEB-INF/views/")&&role.equals("ADMIN")) {
			System.out.println("uri.startsWith(req.getContextPath()+\"/WEB-INF/views/\")&&role.equals(\"ADMIN\")");
			chain.doFilter(request, response);
			return;
		}
		*/
		/*
		if(uri.endsWith("AddStudentServlet")||uri.endsWith("ListStudentsServlet")&&role.equals("ADMIN")) {
			chain.doFilter(request, response);
			return;
		}
		*/
		res.sendError(HttpServletResponse.SC_FORBIDDEN,"ACCESS DENIED");
		
		
	}

	 
 
}
