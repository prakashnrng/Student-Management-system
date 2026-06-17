<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
  <%--  <%
if (session == null || session.getAttribute("NAME") == null) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
    return;
}
    %> --%>
<!DOCTYPE html>
<html>
<head>
 
<title>Success</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h2 style="color:green">Operation Successfull</h2>
<p>${message }</p>
<a href="ListStudentsServlet">Back to Student List</a>

</body>
</html>