<%-- 
    Document   : paginaError
    Created on : 09/01/2009, 11:29:42 PM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
    </head>
    <body>
	<h1>Error</h1>
	<p><%=exception.getMessage()%></p>
	<a href="matematica.html">Retornar</a>
    </body>
</html>