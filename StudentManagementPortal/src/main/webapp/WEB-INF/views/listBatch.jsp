<jsp:include page="navbar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.studentportal.model.Batch"%>
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
<title>Insert title here</title>
</head>
<body>
<%
List<Batch> li=(List<Batch>)request.getAttribute("BATCHES");
if(li==null||li.isEmpty()){
%>
<h1> no records fount</h1>
<%
}else{
	%>


<table>
<tr><td>BatchName</td>
<td>Batch Timings</td>
<td>Trainer</td>
</tr>
<%
for(Batch bref:li){
%>

<tr><td><%=bref.getName() %></td>
<td><%=bref.getTiming() %></td>
<td><%=bref.getTrainer() %></td>
<td>
<form action="<%=request.getContextPath() %>/admin/BatchWiseStudentsServlet" >
 <input type="hidden" name="id" value="<%=bref.getId() %>"/>
<input type="submit" value="ViewStudents"/>
</form>
</td>
<td>
<form action="<%=request.getContextPath() %>/admin/EditBatchServlet" method="post">
 <input type="hidden" name="id" value="<%=bref.getId() %>"/>
<input type="submit" value="EDIT"/>
</form>
</td>
<td>
<form action="<%=request.getContextPath() %>/admin/DeleteBatchServlet" method="post">
 <input type="hidden" name="id" value="<%=bref.getId() %>"/>
<input type="submit" value="DELETE"/>
</form>

</td>
</tr>
<%
}
}
%>

</table>
<%
int currentPage=((Integer)request.getAttribute("PAGE")).intValue();
int totalpages=((Integer)request.getAttribute("TOTAL")).intValue();



%>
  
 
<%
if(currentPage>1){
%>
<form action="<%=request.getContextPath() %>/admin/ListBatchServlet">
 <input type="hidden" name="page" value="<%= currentPage-1%>"/>&nbsp
  <input type="submit" value="previous"/>&nbsp
</form>
<% 
}
%>
<%
for(int i=1;i<=totalpages;i++){
	%>
 
<form action="<%=request.getContextPath() %>/admin/ListBatchServlet">
<input type="hidden" name="page" value="<%= i%>"/> &nbsp
<input type="submit" value="<%= i%>"/> &nbsp
</form>	
 
<% 
}
%>

<%
if(currentPage<totalpages){
%>
<form action="<%=request.getContextPath() %>/admin/ListBatchServlet">
 <input type="hidden" name="page" value="<%= currentPage+1%>"/> &nbsp
  <input type="submit" value="next"/> &nbsp
</form>
<% 
}
%>

</body>
</html>