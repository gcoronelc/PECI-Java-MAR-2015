<%-- 
    Document   : demo06
    Created on : 23/01/2009, 04:11:53 AM
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
	<c:forEach var="n" begin="1" end="10">
	    <p>${n} Perú Campeon</p>
	</c:forEach>
    </body>
</html>
