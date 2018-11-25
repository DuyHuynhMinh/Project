<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="org.hibernate.Session,java.util.*,javax.naming.*,javax.persistence.EntityManager,com.ca.mysqlEJB.HardwareEntity"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252" />
<title>WebClient</title>
</head>
<body>
	<%
	out.println("Test Server ");

    EntityManager em = InitialContext.doLookup("java:/brokerPU");

    HardwareEntity hardware = new HardwareEntity();
    hardware.setVendor("F5");
    hardware.setValue(100);

    ((Session)em.getDelegate()).saveOrUpdate(hardware);

    out.println("End ");

	%>
</body>
</html>