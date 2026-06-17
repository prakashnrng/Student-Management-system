<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="navbar.jsp"/>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
     <%
if (session == null ||! "ADMIN".equals( session.getAttribute("ROLE"))) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
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
 
<form action="admin/UpdateBatchServlet" method="post">
<table>
<tr>
<td>
<input type="hidden" name="id" value="${BATCH.id }">
</td>
</tr>
<tr>
<td>Batch Name</td>
<td>
<input type="text" name="name" value="${BATCH.name }" >
</td></tr>

<tr>
<td>Batch Timings</td>
<td>
<input type="text" name="timing" value="${BATCH.timing }">
</td>
</tr>
<tr>
<td>Trainer</td>
<td>
<input type="text" name="trainer" value="${BATCH.trainer }">
</td>
</tr>
<tr><td><input type="submit" value="submit"/></td></tr>

</table>



</form>
</body>
</html>