<%-- 
    Document   : demo12
    Created on : 25/01/2009, 07:24:49 AM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
    </head>
    <body>
	<c:url value="demo05.jsp" var="destino">
	    <c:param name="nota" value="15"/>
	</c:url>
	<a href="${destino}">Enlace</a>
    </body>
</html>
