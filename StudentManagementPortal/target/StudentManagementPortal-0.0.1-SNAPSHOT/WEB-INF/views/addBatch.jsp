<jsp:include page="navbar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%-- <%
if (session == null || session.getAttribute("NAME") == null) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
    return;
}
%> --%>
 <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="admin/BatchServlet">
<table>
<tr>
<td>Batch Name</td>
<td>
<input type="text" name="name">
</td></tr>
<tr>
<td>Timings</td>
<td>
<input type="text" name="timing"></td></tr>

<tr>
<td>Trainer</td>
<td>
<input type="text" name="trainer"></td></tr>
<tr><td>
<input type="submit" value="submit"/>
</td>
</tr>
</table>

</form>

</body>
</html>