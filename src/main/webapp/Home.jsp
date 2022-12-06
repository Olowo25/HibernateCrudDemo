<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
page Encoding="ISO-8859-1"%>
<!DOCTYPEhtmlPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=ISO-8859-1">
<title>:: Home ::</title>
</head>
<body>
<table  width="100%">
<tr bgcolor=F9F9F3>
<td align="left"><h1>Login Success.....</h1><a href="logout.jsp">logout</a></td>
<td align="right">
<h2>
<%!String username=""; %>
Hi, <% username=(String)session.getAttribute("username");
if(username!=""&& username!=null){
	
    }else{
     response.sendRedirect("login.jsp"); 	
	
    }

%>
</h2>
</td>
<t><%=session.getAttribute("msg")%></t>
</tr>
<tr>
<td colspan="2"><h1 align="center"></br> </br> comming soon...., website under construction</h1></td>
</tr>
<tr><td><a href="update.jsp">Change password</a></td></tr>
<tr><td><a href="delete.jsp">Delete account</a></td></tr>
</table>
</body>
</html>
