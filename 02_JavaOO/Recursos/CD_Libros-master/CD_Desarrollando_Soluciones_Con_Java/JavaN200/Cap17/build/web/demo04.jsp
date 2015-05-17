<%-- 
    Document   : demo04
    Created on : 12/01/2009, 08:28:54 AM
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
	<p>Nombre: <%=request.getParameter("nombre")%></p>
	<p>Nombre: <%=request.getParameter("apellido")%></p>
    </body>
</html>
