<jsp:include page="navbar.jsp"/>
<%-- 
<div id="result">
    <jsp:include page="batchWiseStudentsTable.jsp"/>
</div> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.studentportal.model.Student,com.studentportal.model.Batch,java.util.List"%>
   <%
if (session == null ||! "ADMIN".equals( session.getAttribute("ROLE"))) {
    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/login.jsp");
    return;
}
    %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
let typingTimer;
const delay=500;
function  searchStudents(page) {
	let keyword=document.getElementById("keyword").value;
	let batchid=document.getElementById("batchid").value;
	fetch("<%=request.getContextPath() %>/admin/BatchWiseStudentsServlet?id="+batchid+
		"&page="+page+
		"&keyword="+encodeURIComponent(keyword),
		{
		headers:{"X-Requested-With":"XMLHttpRequest"}
	})
		.then(res=>res.text())
		.then(data=>{
			document.getElementById("result").innerHTML=data;
			
		});
	
}
 
document.addEventListener("DOMContentLoaded",function(){
	
	const input=document.getElementById("keyword");
	input.addEventListener("keyup",function(){
		
		clearTimeout(typingTimer);
		typingTimer=setTimeout(()=>{
			searchStudents(1);
		},delay);
		
	});
});
 

function loadPage(page){
	searchStudents(page);
}
</script>
</head>

<body>
<%
Integer cp=((Integer)request.getAttribute("PAGE"));
Integer tp=((Integer)request.getAttribute("TOTPAGE"));
int currentPage=cp==null?1:cp.intValue();
int totalpages=tp==null?1:tp.intValue();
%>
<%

Batch ba=(Batch)(request.getAttribute("BATCH"));
//System.out.println("ba = "+ba);

%>
 

<%
List<Student> li=(List<Student>)request.getAttribute("STUDENTS");
//System.out.println("li = "+li);
%>

<%
if(li==null||li.isEmpty()||ba==null){
%>

<p>No Record found</p>
<%
}else{
	String timings=ba.getTiming();
%>
<h1>Batch timings (<%=timings %>)</h1>
<h2>Trainer name <%=ba.getTrainer() %></h2>
 
 <input type="hidden" id="batchid" value="<%=ba.getId() %>">
 <input type="search" id="keyword" placeholder="Search by name / email / phone">
 <div id="result">
 <jsp:include page="/WEB-INF/views/batchWiseStudentsTable.jsp"/>
 </div>
 <!-- <button type="button" onclick="searchStudents(1)">Search </button> -->

<%-- <form action="BatchWiseStudentsServlet" method="get">


<tr><td>Search By Email or name or phone</td>
<td><input type="hidden" name="id" value="<%=ba.getId() %>"></td>
<td><input type="hidden" name="page" value="1"></td>
<td><input type="search" name="keyword" value="<%= request.getAttribute("KEYWORD")==null? "" :request.getAttribute("KEYWORD") %>"/></td>

</tr>
<tr><td>
<input type="submit" value="search">
</td></tr>
</table>
</form>
 
 --%>
 
 
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
<form action="<%=request.getContextPath() %>/admin/BatchWiseStudentsServlet">
 <input type="hidden" name="page" value="<%= currentPage-1%>"/>&nbsp
 <input type="hidden" name="id" value="<%= ba.getId()%>"/>&nbsp
 <input type="hidden" name="keyword" value="<%= request.getAttribute("KEYWORD")%>"/>&nbsp
  <input type="submit" value="previous"/>&nbsp
</form>
<% 
}
%>
<%
for(int i=1;i<=totalpages;i++){
	%>
 
<form action="<%=request.getContextPath() %>/admin/BatchWiseStudentsServlet">
<input type="hidden" name="page" value="<%= i%>"/> &nbsp
<input type="hidden" name="id" value="<%= ba.getId()%>"/>&nbsp
<input type="hidden" name="keyword" value="<%= request.getAttribute("KEYWORD") %>"  />&nbsp
<input type="submit" value="<%= i%>"/> &nbsp
</form>	
 
<% 
}
%>

<%
if(currentPage<totalpages){
%>
<form action="<%=request.getContextPath() %>/admin/BatchWiseStudentsServlet">
 <input type="hidden" name="page" value="<%= currentPage+1%>"/> &nbsp
 <input type="hidden" name="id" value="<%= ba.getId()%>"/>&nbsp
 <input type="hidden" name="keyword" value="<%= request.getAttribute("KEYWORD") %>"  />&nbsp
  <input type="submit" value="next"/> &nbsp
</form>
<% 
}
%>

<%
}
%>
  
</body>
</html>