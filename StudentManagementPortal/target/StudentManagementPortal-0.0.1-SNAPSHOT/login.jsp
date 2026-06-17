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
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
<table>
<tr><td>Name</td>
<td>
<input type="text" name="uname"></input>
</td></tr>
<tr><td>password</td>
<td><input type="password" name="password"/>
</td>
</tr>
<tr><td><input type="submit" value="submit"/></td></tr>



</table>
</form>
<%
String str=(String)request.getAttribute("TRUE");
if(str!=null&&str.equals("true")){
	 %>
<h3>INVALID USERNAME OR PASSWORD</h3>
<%
}
%>
</body>
</html>