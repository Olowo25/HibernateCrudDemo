<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
page Encoding="ISO-8859-1"%>
<!DOCTYPEhtml>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate();
request.getRequestDispatcher("login.jsp").forward(request, response);
%>
</body>
</html>
