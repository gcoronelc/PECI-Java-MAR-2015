<%-- 
    Document   : demo05
    Created on : 22/01/2009, 12:16:14 PM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Demo 05</title>
    </head>
    <body>
	<c:set var="nota" value="${param.nota}"/>
	Nota:<c:out value="${nota}"/><br>
	Condición: 
	<c:choose>
	    <c:when test="${nota >= 14}">Aprobado</c:when>
	    <c:when test="${nota >= 11}">Asistente</c:when>
	    <c:when test="${nota >= 0}">Desaprobado</c:when>
	    <c:otherwise>Nota Fuera de Rango</c:otherwise>
	</c:choose>
    </body>
</html>
