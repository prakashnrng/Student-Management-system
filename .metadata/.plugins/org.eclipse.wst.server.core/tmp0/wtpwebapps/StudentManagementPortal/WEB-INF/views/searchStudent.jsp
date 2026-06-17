<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%--  <%
if (session == null || session.getAttribute("NAME") == null) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
    return;
}
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>search student by phone number</h1>
<form action="SearchStudentServlet" method="get">
<table>
<tr><td>
Enter phone</td>
<td>
<input type="text" name="phone"></td></tr>
<tr><td>
<input type="submit" value="search"/></td></tr>

</table>
</form>

<c:if test="${NOTFOUND}">
 	<p> record not found</p>
</c:if>

</body>
</html>