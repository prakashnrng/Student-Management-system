<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%-- <%
if (session == null || session.getAttribute("NAME") == null) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
    return;
}
%>
 --%>
<!DOCTYPE html>
<html>
<head>
 <style>
 body{font-family:Arial;margin:0;}
 .navbar{
 background-color: #333;
 overflow: hidden;
 
 }
 .navbar a{
 float:left;
 display: block;
 color:white;
 text-align:center;
 padding:14px 16px;
 text-decoration: none;
 
 }
.navbar a:hover {
	background-color:#ddd;
	color:black;
}
 
 </style>
</head>
<body>
<div class="navbar">
 
<a href="AddStudentServlet">Add Student</a>
<a href="ListStudentsServlet">View Student</a>
<a href="<%=request.getContextPath() %>/admin/ListBatchServlet">view Batch</a>
<a href="HomeServlet">Home</a>
<a href="addBatch">AddBatch</a>
<!-- <a href="SelectBatchServlet">View Students by Batch</a> -->
<a href="<%=request.getContextPath() %>/admin/LogoutServlet">Logout</a>


</div>
</body>
</html>