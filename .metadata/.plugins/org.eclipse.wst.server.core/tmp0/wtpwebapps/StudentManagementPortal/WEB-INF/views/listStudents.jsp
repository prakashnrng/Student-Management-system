<jsp:include page="navbar.jsp"/>
<%@ page language="java" import="com.studentportal.model.Student,com.studentportal.model.Batch,java.util.List"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
  <%  
if (session == null ||!  "ADMIN".equals((String)session.getAttribute("ROLE"))) {
    response.sendRedirect(request.getContextPath() + "/login.jsp");
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
List<Student> li=(List<Student>)request.getAttribute("students"); 
%>

<%
if(li==null||li.isEmpty()){
%>
<p>No Record found</p>
<%
}else{
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
<%
for(Student st : li){
%>
<tr>
  <td><%=st.getName()%></td>
  <td><%=st.getEmail()%></td>
  <td><%=st.getPhone()%></td>
  <td><%=st.getGender()%></td>
  <td><%=st.getCourse()%></td>
  <%-- <td>
   
  <select name="batch_id">
  <%
  List<Batch> lref=(List<Batch>)request.getAttribute("BATCHES");
  if(lref!=null){
  for(Batch bref:lref){
	  
	  %>
	   <option value="<%=bref.getId()%>"><%=bref.getTiming() %></option>
	  <% 
  }
  }
  %>
  
  </select></td>   --%>
     <td><%=st.getBatchid()%></td>    
   
  <td><%=st.getJoinDate()%></td>
  <td><%=st.getAddress()%></td>
  <td>
  
  <!-- <form action="admin/EditStudentServlet">  -->
  <form action="<%=request.getContextPath() %>/admin/EditStudentServlet">
  <input type="hidden"  name="id" value="<%=st.getId()%>"/>
  
     <button type="submit">Edit</button>
     
     </form>
     <form action="<%=request.getContextPath() %>/admin/DeleteStudentServlet">
     <input type="hidden" name="id" value="<%=st.getId() %>">
     <button>Delete</button>
     </form>
  </td>
</tr>
<%
}
%>
</table>
<%
}
%>

<%
int currentPage=((Integer)request.getAttribute("PAGE")).intValue();
int totalpages=((Integer)request.getAttribute("TOTAL")).intValue();



%>
  
 
<%
if(currentPage>1){
%>
<form action="<%=request.getContextPath() %>admin/ListStudentsServlet">
 <input type="hidden" name="page" value="<%= currentPage-1%>"/>&nbsp
  <input type="submit" value="previous"/>&nbsp
</form>
<% 
}
%>
<%
for(int i=1;i<=totalpages;i++){
	%>
 
<form action="<%=request.getContextPath() %>/admin/ListStudentsServlet">
<input type="hidden" name="page" value="<%= i%>"/> &nbsp
<input type="submit" value="<%= i%>"/> &nbsp
</form>	
 
<% 
}
%>

<%
if(currentPage<totalpages){
%>
<form action="<%=request.getContextPath() %>/admin/ListStudentsServlet">
 <input type="hidden" name="page" value="<%= currentPage+1%>"/> &nbsp
  <input type="submit" value="next"/> &nbsp
</form>
<% 
}
%>
 
</body>
</html>