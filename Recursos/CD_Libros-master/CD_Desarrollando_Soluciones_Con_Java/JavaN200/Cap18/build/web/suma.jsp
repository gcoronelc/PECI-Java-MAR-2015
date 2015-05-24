<%-- 
    Document   : suma
    Created on : 24/01/2009, 11:23:02 AM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
    </head>
    <body>
	<c:set var="n1" value="${param.n1}"/>
	<c:set var="n2" value="${param.n2}"/>
	<c:set var="suma" value="${n1 + n2}"/>
	n1 = ${n1}<br>
	n2 = ${n2}<br>
	suma = ${suma}<br>
    </body>
</html>
