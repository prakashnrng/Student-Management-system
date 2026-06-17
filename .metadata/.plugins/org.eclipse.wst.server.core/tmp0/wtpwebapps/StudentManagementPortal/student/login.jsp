<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    
 <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student login</title>
</head>
<body>
<%
String error=(String)request.getAttribute("ERROR");
if(error!=null &&! error.isEmpty()){
	%>
	<h1><%=error %></h1>
	<%
}
%>
<h2>Student Login</h2>
<form action="StudentLoginServlet" method="post">
<table>
<tr><td>Enter your email or phone</td>
<td>
<input type="text" name="keyword" />
</td>
</tr>
<tr><td>Enter password</td>
<td>
<input type="password" name="pwd"/>
</td></tr>
<tr> 
<td>
<input type="submit" name="submit"/>
</td></tr>

</table>
</form>
</body>
</html>