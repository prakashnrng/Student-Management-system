<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="navbar.jsp"%> 
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
   <%
if (session == null ||! "ADMIN".equals(session.getAttribute("ROLE"))) {
	System.out.println("home.jsp session==null ||  sess.getAttri(NAME) = "+session);
    response.sendRedirect(request.getContextPath() + "/login.jsp");
    return;
}
    %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Student Portal</h1>

<p>This portal helps you manage student admissions, batches, and records.</p>

<a href="<%=request.getContextPath()%>/admin/AddStudentServlet">
<button type="button">Go to Add Student </button>
</a>
<a href="<%=request.getContextPath()%>/admin/ListStudentsServlet">
<button type="button">View All Students</button>
</a>
<h1>Total number of Student <%=request.getAttribute("total")%></h1>
</body>
</html>