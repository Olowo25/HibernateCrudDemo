<%@ page import="com.kambok.dao.BaseDaoImpl"%>
<%@ page import="com.kambok.dao.BaseDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPEhtml>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

 BaseDao bd=new BaseDaoImpl();
	  bd.deleteUser((String)session.getAttribute("username"));
	
	//response.sendRedirect("login.jsp");
	  request.getRequestDispatcher("login.jsp").include(request, response);
	  request.setAttribute("msg", "Account deleted");
%>
</body>
</html>
