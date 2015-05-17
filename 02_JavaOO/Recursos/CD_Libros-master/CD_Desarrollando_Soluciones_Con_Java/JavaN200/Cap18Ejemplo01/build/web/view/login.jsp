<%-- 
	 Document   : main
	 Created on : 26/01/2009, 02:24:38 PM
	 Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<base href="<%= request.getRequestURL().toString()%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/EurekaBank.css"/>
		<title>JSP Page</title>
	</head>
	<body>
		<h1>EurekaBank</h1>
		<h2>Ingreso al Sistema</h2>
		<form name="form1" method="post" action="<c:url value='/EmpleadoController'/>">
			<table width="273">
				<tr>
					<td width="58">Usuario</td>
					<td colspan="2">
						<input name="usuario" type="text" id="usuario" size="15" maxlength="15">		   
					</td>
				</tr>
				<tr>
					<td>Clave</td>
					<td width="104">
						<input name="clave" type="password" id="clave" size="15" maxlength="15">
					</td>
					<td width="95">
						<input type="submit" name="conectar" id="conectar" value="Conectar">
					</td>
				</tr>
			</table>
		</form>
		<c:if test="${! empty requestScope.mensaje}">
			<div id="mensaje">Mensaje: ${requestScope.mensaje}</div>
		</c:if>
		<c:if test="${! empty requestScope.error}">
			<div class="error" id="error">Error: ${requestScope.error}</div>
		</c:if>
	</body>
</html>
