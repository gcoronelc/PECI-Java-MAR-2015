<%-- 
    Document   : demo01
    Created on : 05/01/2009, 01:34:48 PM
    Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP - Demo 01</title>
    </head>
    <body>
	<%!	
	private int n1 = 15;
	private int n2 = 10;
	private int s;
	%>
	<h4>Suma de Dos N&uacute;meros</h4>
	<%
		s = n1 + n2;
		out.println("n1 = " + n1 + "<br>");
		out.println("n2 = " + n2 + "<br>");
		out.println("suma = " + s + "<br>");
	%>
    </body>
</html>