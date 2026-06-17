<jsp:include page="navbar.jsp"/>
<%@ page language="java" import="java.util.List,com.studentportal.model.Student,com.studentportal.model.Batch,java.text.SimpleDateFormat"%>
<%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>  
   <%
if (session == null ||! "ADMIN".equals(session.getAttribute("ROLE"))) {
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
Student st=(Student)request.getAttribute("student");
if(st!=null){
%>
 <form action="<%=request.getContextPath() %>admin/EditStudentServlet" method="post">  
<!-- <form action="/EditStudentServlet" method="post"> -->
 <table>
 <tr>
 <td>Name</td>
 <td><input type="text" name="name" value="<%=st.getName() %>"/></td>
 </tr>
 <tr>
 <td>Email</td>
 <td><input type="text" name="email" value="<%=st.getEmail() %>"/></td>
 </tr>
 
 <tr>
 <td>phone</td>
 <td><input type="text" name="phone" value="<%=st.getPhone() %>"/></td>
 </tr>
 
 <tr>
 <td>gender</td>
 <td>
  <input type="radio" name="gender" value="M" <%=st.getGender() =='M'? "checked" :"" %>/>Male
  
  
  <input type="radio" name="gender" value="F" <%=st.getGender() =='F'? "checked" :"" %>/>Female
 
  <input type="radio" name="gender" value="O" <%=st.getGender() =='O'? "checked" :"" %>/>Other</td>
 
 </tr>
 <tr>
 <td>select course</td>
 <td><select name="course">
 <option value="java" <%= st.getCourse().equals("java")?"selected":"" %> >Java </option>
 <option value="c" <%= st.getCourse().equals("c")?"selected":"" %>  >c</option>
 <option value="python" <%= st.getCourse().equals("python")?"selected": "" %>>python</option>
 
 </select>
 </td>
 </tr>
 <tr>
 <td>select Date of Birth</td>
 <%
 SimpleDateFormat sdf=new SimpleDateFormat("mm-dd-yyyy");
 String dobfor=st.getDob()!=null?sdf.format(st.getDob()):"";
 
 
 %>
 <%
 // enclose <%=st.getDob()> or any value with the double quote 
 %>
 <td><input type="date" name="dob" value="<%= st.getDob() %>"/></td></tr>
 <tr>
 <td>Join Date</td>
 <td><input type="date" name="join_date" value="<%=st.getJoinDate()%>"/>
 </td>
 </tr>
 <tr>
  <td>Batch ID</td>
  <td>
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
  
  </select></td>  
 </tr>
 
 
 
 <%-- <tr>
 <td>Batch ID</td>
 <td><input type="text" name="batch_id" value="<%=st.getBatchid() %>"/>
 </td></tr> --%>
 <tr><td>
 <textarea name="address" rows="3" cols="30" >
 <%=st.getAddress() %>
 </textarea>
 </td></tr>
 
 <tr><td>
 <input type="hidden" name="id" value="<%=st.getId() %>"/>
 </td></tr>
 <tr>
  <td colspan="2" align="center">
    <input type="submit" value="Submit Student Details">
  </td>
</tr>
 
 </table>
 
 </form>
<%
}else{
	

%>
<h2>no records found</h2>
<%
}
%>
</body>
</html>