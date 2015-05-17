<%-- 
    Document   : suma
    Created on : 09/01/2009, 01:52:03 PM
    Author     : Gustavo Coronel
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="paginaError.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
// Datos
		int dividendo = Integer.parseInt(request.getParameter("dividendo"));
		int divisor = Integer.parseInt(request.getParameter("divisor"));
// Proceso
		int cociente = dividendo / divisor;
		int residuo = dividendo % divisor;
%>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Matematica</title>
    </head>
    <body>
	<h1>División</h1>
	<table width="190">
	    <tr>
		<td width="100">Dividendo</td>
		<td width="78"><%=dividendo%></td>
	    </tr>
	    <tr>
		<td>Divisor</td>
		<td><%=divisor%></td>
	    </tr>
	    <tr>
		<td>Cociente</td>
		<td><%=cociente%></td>
	    </tr>
	    <tr>
		<td>Residuo</td>
		<td><%=residuo%></td>
	    </tr>
	</table>
	<p><a href="matematica.html">Retornar</a></p>
    </body>
</html>
