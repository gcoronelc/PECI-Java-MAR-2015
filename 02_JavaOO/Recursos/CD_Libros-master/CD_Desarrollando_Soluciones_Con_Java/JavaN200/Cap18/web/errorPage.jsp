<%-- 
    Document   : errorPage
    Created on : 22/01/2009, 09:54:27 AM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Página de Error - errorPage</title>
    </head>
    <body>
	<p>URI del requerimiento fallido: ${pageContext.errorData.requestURI}</p>
	<p>Quien lanzo el error: ${pageContext.errorData.servletName}</p>
	<p>Código de error: ${pageContext.errorData.statusCode}</p>
	<p>Excepción: ${pageContext.errorData.throwable.class}</p>
	<p>Mensaje: ${pageContext.errorData.throwable.message}</p>
    </body>
</html>
