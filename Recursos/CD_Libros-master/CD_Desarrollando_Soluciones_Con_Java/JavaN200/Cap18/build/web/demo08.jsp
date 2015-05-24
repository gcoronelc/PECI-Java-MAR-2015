<%-- 
    Document   : demo08
    Created on : 24/01/2009, 07:42:34 AM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
    </head>
    <body>
	<c:set var="paises" value="Perú,España,,Argentina,Brasil,Colombia"/>
	<ul>
	    <c:forTokens items="${paises}" delims="," var="pais">
		<li><c:out value="${pais}"/></li>
	    </c:forTokens>
	    
	</ul>
    </body>
</html>
