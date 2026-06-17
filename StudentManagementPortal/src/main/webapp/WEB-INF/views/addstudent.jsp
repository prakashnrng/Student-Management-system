<jsp:include page="navbar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.List,com.studentportal.model.Batch"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
 <%
 System.out.println("addstudent.jsp before if");
if (session == null ||! "ADMIN".equals((String)session.getAttribute("ROLE"))) {
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
 <form action="admin/addStudent" method="post">
 <table>
 <tr>
 <td>Name</td>
 <td><input type="text" name="name"/></td>
 </tr>
 <tr>
 <td>Email</td>
 <td><input type="text" name="email"/></td>
 </tr>
 
 <tr>
 <td>phone</td>
 <td><input type="text" name="phone"/></td>
 </tr>
 
 <tr>
 <td>gender</td>
 <td>
  <input type="radio" name="gender" value="M"/>Male
  
  
  <input type="radio" name="gender" value="F"/>Female
 
  <input type="radio" name="gender" value="O"/>Other</td>
 
 </tr>
 <tr>
 <td>select course</td>
 <td><select name="course">
 <option value="java" >Java </option>
 <option value="c"  >c</option>
 <option value="python">python</option>
 
 </select>
 </td>
 </tr>
 <tr>
 <td>select Date of Birth</td>
 <td><input type="date" name="dob"/></td></tr>
 <tr>
 <td>Join Date</td>
 <td><input type="date" name="join_date"/>
 </td>
 </tr>
 <tr>
 <td>Batches</td>
<td> 
 <%
 List<Batch> li=(List<Batch>)request.getAttribute("BATCHES");
 if(li!=null){
 %>
 
 <!-- <td><input type="text" name="batch_id"/> -->
 
<select name="batch_id">
<%
 for(Batch bref:li){
	 
	 %>
   <option value="<%=bref.getId()%>"><%=bref.getTiming() %></option>
<%
 }
%>


</select>
<% 
 }
%>
 </td></tr>
 <tr><td>
 <textarea name="address" rows="3" cols="30"></textarea>
 </td></tr>
 <tr><td>
 <input type="hidden" name="action" value="add">
 </td></tr>
 <tr>
  <td colspan="2" align="center">
    <input type="submit" value="Submit Student Details">
  </td>
</tr>
 
 </table>
 
 </form>

</body>
</html>