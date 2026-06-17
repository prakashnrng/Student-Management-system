<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.studentportal.model.Student"
    %>
    <%--    <%
if (session == null || session.getAttribute("NAME") == null) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
    return;
}
    %> --%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student INFO</h1>
 


 

<% 
Student st=(Student)request.getAttribute("STUDENT");


%>
<table border="1" cellpadding="8" cellspacing="0">
<tr>
  <th>Name</th>
  <th>Email</th>
  <th>Phone</th>
  <th>Gender</th>
  <th>Course</th>
  <th>Batch ID</th>
  <th>Join Date</th>
  <th>Address</th>
  <th>Actions</th>
</tr>

<tr>
  <td><%=st.getName()%></td>
  <td><%=st.getEmail()%></td>
  <td><%=st.getPhone()%></td>
  <td><%=st.getGender()%></td>
  <td><%=st.getCourse()%></td>
  <td><%=st.getBatchid()%></td>
  <td><%=st.getJoinDate()%></td>
  <td><%=st.getAddress()%></td>
  <td>
  </td></tr>
</table>

<a href="searchStudent.jsp">SearchStudent</a>
</body>
</html>