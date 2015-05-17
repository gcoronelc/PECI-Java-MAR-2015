<%-- 
    Document   : demo11
    Created on : 24/01/2009, 11:46:49 AM
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
	<c:redirect url="http://www.minedu.gob.pe/noticias/index.php">
	    <c:param name="id" value="7539"/>
	</c:redirect>
    </body>
</html>
