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
						Depósito		    
					</a>		
				</td>
				<td width="110">
					<a href="<c:url value='/view/retiro.jsp' />">
						Retiro		   
					</a>		
				</td>
				<td width="113">
					<a href="<c:url value='/FinalizarSession' />">
					Salir</a>
				</td>
			</tr>
		</table>
		<h2>Depósito</h2>
		<form name="form1" method="post" action="<c:url value='/CuentaController'/>">
			<input type="hidden" name="op" value="01" />
			<table width="306">
				<tr>
					<td width="81">Nro.  Cuenta</td>
					<td colspan="2">
						<input name="cuenta" type="text" class="fieldEdit" id="cuenta" size="10" maxlength="8">
					</td>
				</tr>
				<tr>
					<td>Importe</td>
					<td width="92">
						<input name="importe" type="text" class="fieldEdit" id="importe" size="10" maxlength="10">
					</td>
					<td width="117">
						<input name="ejecutar" type="submit" class="button" id="ejecutar" value="Ejecutar">
					</td>
				</tr>
			</table>
		</form>
		<c:if test="${requestScope['mensaje'] != null}">
			<div id="mensaje">
				<h2>Mensaje</h2>
				<p>${requestScope["mensaje"]}</p>
			</div>
		</c:if>
		<c:if test="${requestScope['error'] != null}">
			<div id="Error">
				<h2>Error</h2>
				<p class="error">${requestScope["error"]}</p>
			</div>
		</c:if>
	</body>
</html>