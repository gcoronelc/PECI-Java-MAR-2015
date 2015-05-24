<%-- 
    Document   : demo07
    Created on : 12/01/2009, 11:55:55 AM
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
	<jsp:useBean id="fecha" class="java.util.Date" scope="page"/>
	<%=fecha%>
	
    </body>
</html>
