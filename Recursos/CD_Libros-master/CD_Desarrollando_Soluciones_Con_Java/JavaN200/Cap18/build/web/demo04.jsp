<%-- 
    Document   : demo04
    Created on : 22/01/2009, 12:03:56 PM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty requestScope.mensaje}">
    <jsp:forward page="Demo04">
	<jsp:param name="usuario" value="${param.usuario}"/>
    </jsp:forward>
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Demo 04</title>
    </head>
    <body>
	<c:set var="mensaje" value="${requestScope.mensaje}" />
	<c:set var="empleadoTO" value="${requestScope.empleadoTO}" />
	<c:out value="${mensaje}"/>
	<c:if test="${empleadoTO != null}">
	    <p>Nombre: ${empleadoTO.nombre}</p>
	    <p>Paterno: ${empleadoTO.paterno}</p>
	    <p>Materno: ${empleadoTO.materno}</p>
	</c:if>
	<c:if test="${empleadoTO == null}">
	    <p>No existe el usuario.</p>
	</c:if>
    </body>
</html>
