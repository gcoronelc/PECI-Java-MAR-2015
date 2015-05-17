<%-- 
    Document   : demo09
    Created on : 14/01/2009, 10:15:30 AM
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
	<p>Hola: <%= pageContext.getAttribute("nombre",pageContext.REQUEST_SCOPE) %></p>
	<p>De: <%= pageContext.getAttribute("pais", pageContext.REQUEST_SCOPE) %></p>
	
    </body>
</html>
