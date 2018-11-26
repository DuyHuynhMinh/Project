<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.ca.hibernatemanage.*,com.ca.activemq.*"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252" />
<title>WebClient</title>
</head>
<body>
	<%
	out.println("Test Server ");

	OCMessageWildfly oc = new OCMessageWildfly();

	oc.sendMessage();


    out.println("End ");

	%>
</body>
</html>