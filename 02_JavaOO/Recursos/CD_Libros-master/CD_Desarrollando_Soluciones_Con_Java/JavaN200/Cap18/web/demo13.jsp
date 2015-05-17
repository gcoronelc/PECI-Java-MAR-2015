<%-- 
    Document   : demo13
    Created on : 25/01/2009, 07:25:19 AM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	<c:catch var="error1">
	    <fmt:parseNumber var="total" value="ABCD"/>
	    Importe: ${dato.total}<br>
	</c:catch>
	<c:if test="${not empty error1}">
	    Lo sentimos, no existe el dato solicitado.<br>
	    Error: ${error1}
	</c:if>
    </body>
</html>
