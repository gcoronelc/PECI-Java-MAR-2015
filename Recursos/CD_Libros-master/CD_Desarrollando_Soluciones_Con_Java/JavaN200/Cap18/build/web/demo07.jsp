<%-- 
    Document   : demo07
    Created on : 23/01/2009, 04:18:26 AM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${empty requestScope.mensaje}">
    <jsp:forward page="Demo07">
	<jsp:param name="paterno" value="${param.paterno}"/>
    </jsp:forward>
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Demo 07</title>
    </head>
    <body>
	<c:set var="mensaje" value="${requestScope.mensaje}" />
	<c:set var="lista" value="${requestScope.lista}" />
	<c:out value="${mensaje}"/><br>
	<c:if test="${fn:length(lista) == 0}">
	    <c:out value="No hay elementos."/><br>
	</c:if>
	<c:forEach items="${lista}" var="item">
	    ${item.nombre} ${item.paterno}<br>
	</c:forEach>
    </body>
</html>
