<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
     <%
if (session == null || ! "ADMIN".equals(session.getAttribute("ROLE"))) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
    return;
}
    %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h2 style="color:red;">Something went wrong</h2>
<p>${message }</p>
<a href="listStudents">Try Again</a>

</body>
</html>