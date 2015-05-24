<%-- 
    Document   : demo05
    Created on : 12/01/2009, 10:23:48 AM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
    </head>
    <body>
	<h3>Se incluye el resultado de demo06.jsp</h3>
	<jsp:include page="demo06.jsp" flush="true"/>
	<h3>Se vuelve a la página inicial</h3>
    </body>
</html>
