<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>  
<%

if(session==null||session.getAttribute("NAME")==null){
	response.sendRedirect(request.getContextPath()+"/student/login.jsp");
	return;
}

%>

<%-- <!DOCTYPE html>

<html>

 
<body>
<h1>hi <%=session.getAttribute("NAME") %></h1>
<h1> your batch is id  <%=session.getAttribute("BID") %></h1>

 <h1>hi</h1>
</body>
</html>
 --%>
<html>
<head><title>Dashboard</title></head>
<body>
    <%
        if(session.getAttribute("NAME") == null) {
            out.print("DEBUG: Session is NULL in JSP!");
        }
    %>
    <h1>Welcome, <%= session.getAttribute("NAME") %></h1>
    <p>ID: <%= session.getAttribute("SID") %></p>
    <p>Batch: <%= session.getAttribute("BID") %></p>
    <a href="<%= request.getContextPath()%>/student/Logout">Logout</a>
</body>
</html>