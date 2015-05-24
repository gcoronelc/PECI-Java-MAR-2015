<%-- 
	 Document   : main
	 Created on : 26/01/2009, 03:43:34 PM
	 Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<base href="<%= request.getRequestURL().toString()%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="stylesheet" type="text/css" href="../css/EurekaBank.css"/>
		<title>JSP Page</title>
	</head>
	<body>
		<h1>EurekaBank</h1>
        <table width="318">
      <tr>
		<td width="67">Usuario:</td>
		<td width="239">${sessionScope.empleadoTO.usuario}</td>
      </tr>
        <tr>
        <td>Local:</td>
		<td>${sessionScope.sucursalTO.nombre}</td>
        </tr>
	</table>
    <table width="350">
      <tr class="menu01">
		<td width="111">
		    <a href="<c:url value='/view/deposito.jsp' />">
			Depósito		    </a>		</td>
	  <td width="110">
		    <a href="<c:url value='/view/retiro.jsp' />">
			Retiro		    </a>		</td>
		<td width="113">
		<a href="<c:url value='/FinalizarSession' />">Salir</a></td>
      </tr>
	</table>
    	<p>&nbsp;</p>
	</body>
</html>
