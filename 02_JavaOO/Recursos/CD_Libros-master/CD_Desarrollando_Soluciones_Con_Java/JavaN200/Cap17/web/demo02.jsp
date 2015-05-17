<%-- 
    Document   : demo02
    Created on : 09/01/2009, 10:24:29 AM
    Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Demo 02</title>
    </head>
    <body>
	<%!int cont = 0;%>
	<h1>Demo 02</h1>
	<%cont++;%>
	<h2>n = <%=cont%></h2>
	<% if (Math.random() < 0.5) {%>
	    Este es un <B>agradable</B> día!
	<% } else {%>
	    Este es un <B>mal</B> día!
	<% }%>
	
	 
    </body>
</html>
