<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XamDesk</title>
</head>
<body bgcolor="#e4e3e2">
<%
String contextPath = request.getContextPath();
response.sendRedirect(contextPath+"/xamdeskhome");
//response.sendRedirect(contextPath+"/underconstructionpage");
%>
</body>
</html>