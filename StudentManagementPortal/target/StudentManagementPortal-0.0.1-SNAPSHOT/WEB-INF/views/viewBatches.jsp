<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.studentportal.model.Batch,java.util.List"
        %>
     <%--       <%
if (session == null || session.getAttribute("NAME") == null) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
    return;
}
    %> --%>
<%
//this code is not to cache content from the browser ,bcz browser will cache the page
//even after by clicking logout browser as saved the page, so if we use the three line of below
//code even after clicking logout the brwoser will not cache the pages.
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

 
<table>
<tr><td>
 <p>BatchName</p>
 
</td>
<td>
<p> Timing</p>

</td>
<td>
<p>Trainer</p>
</td>
</tr>
<%
List<Batch> li=(List<Batch>)request.getAttribute("BATCHES");
if(li!=null){
for(Batch bref:li){
%>
 
<tr>
<td><%=bref.getName()%>
</td>
<td><%=bref.getTiming() %></td>
<td><%=bref.getTrainer() %></td>

<td>
<form action="admin/EditBatchServlet">
<input type="hidden"  name="id" value=<%=bref.getId()%>/>
<input type="submit" value="EDIT"/>

</form>
<td>
<td>
<form action="DeleteBatchServlet">
<input type="hidden" name="id" value=<%=bref.getId()%>/>
<input type="submit" value="DELETE"/>

</form>
 </td>


</tr>
 
</table>

<%
}
}
%>
 <form action="/WEB-INF/views/addBatch.jsp">
<input type="button" value="ADDNEWBATCH"/> 
 
 </form>

</body>
</html>