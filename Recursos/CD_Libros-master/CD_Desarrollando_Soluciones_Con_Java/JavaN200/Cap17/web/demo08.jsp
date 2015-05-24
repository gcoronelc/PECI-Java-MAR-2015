<%-- 
    Document   : demo08
    Created on : 14/01/2009, 10:14:09 AM
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
	<%
		request.setAttribute("nombre", "Gustavo");
		request.setAttribute("pais", "Perú");
	%>
	<jsp:forward page="demo09.jsp"/>
    </body>
</html>
