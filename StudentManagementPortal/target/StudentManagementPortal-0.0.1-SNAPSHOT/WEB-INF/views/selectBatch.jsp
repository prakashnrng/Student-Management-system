<jsp:include page="navbar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.studentportal.model.Batch,com.studentportal.dao.BatchDAO"%>
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
<%
BatchDAO bda=new BatchDAO();
List<Batch> li=bda.getAllBatch();

%>

<body>

<form action="BatchWiseStudentsServlet">
<table>
<tr>
<td>
<select name="batch_id">
<%
for(Batch bref:li){
%>
<option value="<%=bref.getId()%>"><%=bref.getTiming() %></option>

<%

}
%>

</select>
</td></tr>
<tr><td><input type="submit" value="submit"></td></tr>

</table>
</form>

</body>
</html>