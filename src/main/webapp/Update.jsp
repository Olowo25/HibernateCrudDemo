<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
page Encoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update"method="post">
<input type="text" name="username" value=" <%=session.getAttribute("username")%>">
<input type="text" name="password">
<input type="submit" value="change">
</form>
</body>
</html>
