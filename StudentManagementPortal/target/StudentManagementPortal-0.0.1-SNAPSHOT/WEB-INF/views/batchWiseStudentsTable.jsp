<%@page    import="com.studentportal.model.Student,com.studentportal.model.Batch,java.util.List"%>
<!DOCTYPE html>
    <%
if (session == null ||! "ADMIN".equals( session.getAttribute("ROLE"))) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
    return;
}
    %> 
 <%
 List<Student> li=(List<Student>)request.getAttribute("STUDENTS");
 Batch ba=(Batch)(request.getAttribute("BATCH"));
int currentPage=((Integer)request.getAttribute("PAGE")).intValue();
int totalpages=((Integer)request.getAttribute("TOTPAGE")).intValue();
String keyword=(String)request.getAttribute("KEYWORD");
%>
 
<%
if(li==null||li.isEmpty()||ba==null){
%>

<p>No Record found</p>
<%
} 
%>
 
 

<table border="1" cellpadding="8" cellspacing="0">
<tr>
  <th>Name</th>
  <th>Email</th>
  <th>Phone</th>
  <th>Gender</th>
  <th>Course</th>
  <th>Batch Timing</th>
  <th>Join Date</th>
  <th>Address</th>
  <!-- <th>Actions</th> -->
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
       <td><%=ba.getTiming()%></td>      
   
  <td><%=st.getJoinDate()%></td>
  <td><%=st.getAddress()%></td>
  
  
 
</tr>
<%
}
%>
</table>
 
 


 
  
 
<%
if(currentPage>1){
%>

<button onclick="loadPage(<%=currentPage-1%>)">prev</button>

<%-- 
<form action="BatchWiseStudentsServlet">
 <input type="hidden" name="page" value="<%= currentPage-1%>"/>&nbsp
 <input type="hidden" name="id" value="<%= ba.getId()%>"/>&nbsp
 <input type="hidden" name="keyword" value="<%= request.getAttribute("KEYWORD")%>"/>&nbsp
  <input type="submit" value="previous"/>&nbsp
</form>
 --%><% 
}
%>
<%
for(int i=1;i<=totalpages;i++){
	%>
 <button onclick="loadPage(<%=i%>)"><%=i%></button>
 
<%-- <form action="BatchWiseStudentsServlet">
<input type="hidden" name="page" value="<%= i%>"/> &nbsp
<input type="hidden" name="id" value="<%= ba.getId()%>"/>&nbsp
<input type="hidden" name="keyword" value="<%= request.getAttribute("KEYWORD") %>"  />&nbsp
<input type="submit" value="<%= i%>"/> &nbsp
</form>	
 --%> 
<% 
}
%>

<%
if(currentPage<totalpages){
%>
<button onclick="loadPage(<%=currentPage+1%>)">Next</button>
<%-- <form action="BatchWiseStudentsServlet">
 <input type="hidden" name="page" value="<%= currentPage+1%>"/> &nbsp
 <input type="hidden" name="id" value="<%= ba.getId()%>"/>&nbsp
 <input type="hidden" name="keyword" value="<%= request.getAttribute("KEYWORD") %>"  />&nbsp
  <input type="submit" value="next"/> &nbsp
</form>
 --%>  
}
%>

<%
}
%>