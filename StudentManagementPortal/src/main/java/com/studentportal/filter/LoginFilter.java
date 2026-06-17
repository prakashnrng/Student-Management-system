package com.studentportal.filter;

 
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
 

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements  Filter {
       
     public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

 	public void destroy() {
		// TODO Auto-generated method stub
	}

 /*
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("loginfilter");
		System.out.println("--------------------");
 HttpServletRequest req=(HttpServletRequest)request;
 HttpServletResponse res=(HttpServletResponse)response;
 HttpSession ses=req.getSession(false);
  String role=(ses!=null ?(String) ses.getAttribute("ROLE"):null);
 boolean loggedin=role!=null && role.equals("ADMIN");
 String path=req.getRequestURI();
 String path1=req.getServletPath();
 
 if(path1.startsWith("/student/")) {
	 chain.doFilter(request,response);
	 return;
 }
 System.out.println("login filter uri = "+req.getRequestURI());
  boolean allowed=path.endsWith("login.jsp")||path.endsWith("LoginServlet");
  
 //String role=(String)ses.getAttribute("ROLE");
  if(allowed||loggedin&&path1.startsWith("/WEB-INF/views/")) {
// if(path.startsWith("/WEB-INF/views/)")&&role.equals("ADMIN")) {
 	 chain.doFilter(request, response);
 	 return;
 }else {
	 res.sendRedirect(req.getContextPath()+"/login.jsp");
 }
 
	//	chain.doFilter(request, response);
	}
*/
 	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
 	        throws IOException, ServletException {
 	    System.out.println("loginfilter");
 	    System.out.println("--------------------");

 	    HttpServletRequest req = (HttpServletRequest) request;
 	    HttpServletResponse res = (HttpServletResponse) response;
 	    HttpSession ses = req.getSession(false);

 	    String role = (ses != null) ? (String) ses.getAttribute("ROLE") : null;
 	    boolean loggedIn = (role != null && role.equals("ADMIN"));

 	    String path = req.getRequestURI();
 	    
 	    String servletPath = req.getServletPath();

 	    // Allow student paths without login
 	    if (servletPath.startsWith("/student/")) {
 	        chain.doFilter(request, response);
 	        return;
 	    }

 	    System.out.println("login filter uri = " + path);

 	    boolean allowed = path.endsWith("login.jsp") || path.endsWith("LoginServlet");

 	     
 	    //if (allowed || (loggedIn && servletPath.startsWith("/WEB-INF/views/"))) {
 	   if (allowed || (loggedIn)) {
 	        chain.doFilter(request, response);
 	        return;
 	    }

 	    // Otherwise redirect to login
 	    res.sendRedirect(req.getContextPath() + "/login.jsp");
 	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
