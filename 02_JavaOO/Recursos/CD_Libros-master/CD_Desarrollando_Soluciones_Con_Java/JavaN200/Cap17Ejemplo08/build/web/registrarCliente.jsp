<%-- 
    Document   : registrarCliente
    Created on : 16/01/2009, 10:15:16 AM
    Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
		ArrayList<String> mensajes = null;
		if (request.getAttribute("mensajes") != null) {
			mensajes = (ArrayList<String>) request.getAttribute("mensajes");
		}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/EurekaBank.css">
	<title>JSP Page</title>
    </head>
    <body>
	<h1>EurekaBank</h1>
	<h2>Registro de Nuevo Cliente</h2>
	<% if (mensajes == null) {%>
	<div id="datos">
	    <h3>Datos</h3>
	    <form name="form1" method="post" action="RegistrarCliente">
		<table width="338">
		    <tr>
			<td width="88">Paterno</td>
			<td width="238">
			    <input name="paterno" type="text" class="fieldEdit" id="paterno" onChange="javascript:this.value=this.value.toUpperCase()" size="25" maxlength="25">
			</td>
		    </tr>
		    <tr>
			<td>Materno</td>
			<td>
			    <input name="materno" type="text" class="fieldEdit" id="materno" onChange="javascript:this.value=this.value.toUpperCase()" size="25" maxlength="25">
			</td>
		    </tr>
		    <tr>
			<td>Nombre</td>
			<td>
			    <input name="nombre" type="text" class="fieldEdit" id="nombre" onChange="javascript:this.value=this.value.toUpperCase()" size="25" maxlength="30">
			</td>
		    </tr>
		    <tr>
			<td>DNI</td>
			<td>
			    <input name="dni" type="text" class="fieldEdit" id="dni" size="8" maxlength="8">
			</td>
		    </tr>
		    <tr>
			<td>Ciudad</td>
			<td>
			    <input name="ciudad" type="text" class="fieldEdit" id="ciudad" onChange="javascript:this.value=this.value.toUpperCase()" size="30" maxlength="30">
			</td>
		    </tr>
		    <tr>
			<td>Dirección</td>
			<td>
			    <input name="direccion" type="text" class="fieldEdit" id="direccion" onChange="javascript:this.value=this.value.toUpperCase()" size="30" maxlength="50">
			</td>
		    </tr>
		    <tr>
			<td>Teléfono</td>
			<td>
			    <input name="telefono" type="text" class="fieldEdit" id="telefono" size="30" maxlength="20">
			</td>
		    </tr>
		    <tr>
			<td>Email</td>
			<td>
			    <input name="email" type="text" class="fieldEdit" id="email" onChange="javascript:this.value=this.value.toLowerCase()" size="30" maxlength="50">
			</td>
		    </tr>
		    <tr>
			<td colspan="2">
			    <input name="grabar" type="submit" class="button" id="grabar" value="Grabar">
			</td>
		    </tr>
		</table>
	    </form>
	</div>
	<% }%>
	<% if (mensajes != null) {%>
	<div id="mensaje">
	    <h3>Mensaje</h3>
	    <% for (String mensaje : mensajes) {%>
	    <p><%= mensaje%></p>
	    <% }%>
	    <p><a href="registrarCliente.jsp">Retornar</a></p>
	</div>
	<% }%>
    </body>
</html>