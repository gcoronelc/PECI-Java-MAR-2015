<%-- 
    Document   : demo01
    Created on : 20/01/2009, 01:34:56 PM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
    </head>
    <body>
	<c:forEach items="${header}" var="item">
	    <c:out value="${item}" /><br/>
	</c:forEach>
	Host: <c:out value="${header.host}"/> <br/>
	Server: ${pageContext.servletContext.serverInfo}<br/>
	Usuario: ${pageContext.request.remoteUser}<br/>
	Aplicación: ${pageContext.request.contextPath}<br/>
	URL: ${pageContext.request.requestURL}<br/>
	Servidor: ${pageContext.servletContext.serverInfo}<br/>
    </body>
</html>
