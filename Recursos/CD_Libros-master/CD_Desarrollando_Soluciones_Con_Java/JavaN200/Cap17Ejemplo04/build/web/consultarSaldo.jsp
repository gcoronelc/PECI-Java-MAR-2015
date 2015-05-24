<%-- 
    Document   : consultarSaldo
    Created on : 09/01/2009, 03:34:01 PM
    Author     : gustavo
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page errorPage="paginaError.jsp" %>
<%!
	// Declaraciones de la página
	enum Estados {FORMULARIO, RESPUESTA, MENSAJE};
	Connection connection = null;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/eurekabank";
	String user = "root";
	String pwd = "";
	String mensaje = "Número de cuenta no existe.";
%>
<%
		// declaración del requerimiento
		Estados estado = Estados.FORMULARIO;
		String cuenta = null;
		Double saldo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from cuenta where chr_cuencodigo=?";

		// Conexión con la base de datos
		if (connection == null) {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, user, pwd);
		}
		// Procesar rquerimiento
		if (request.getParameter("cuenta") != null) {
			// Datos
			cuenta = request.getParameter("cuenta");
			// Proceso
			ps = connection.prepareStatement(query);
			ps.setString(1, cuenta);
			rs = ps.executeQuery();
			if (rs.next()) {
				estado = Estados.RESPUESTA;
				saldo = rs.getDouble("dec_cuensaldo");
			} else {
				estado = Estados.MENSAJE;
			}
			rs.close();
			ps.close();
		}
%>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="eurekaBank.css">
	<title>Consultar Saldo</title>
    </head>
    <body>
	<h1>EurekaBank</h1>
	<h2>Consultar Saldo</h2>
	<% if( estado == Estados.FORMULARIO ) {%>
	<form name="form1" method="post" action="consultarSaldo.jsp">
	    <table width="354">
		<tr>
		    <td width="130">Número de Cuenta</td>
		    <td width="84"><input name="cuenta" type="text" class="fieldEdit" id="cuenta" size="8" maxlength="8"></td>
		    <td width="124"><input name="consultar" type="submit" class="button" id="consultar" value="Consultar"></td>
		</tr>
	    </table>
	</form>
	<% } else if( estado == Estados.RESPUESTA ) { %>
	<table width="257">
      <tr>
		<td width="78">Cuenta</td>
		<td width="167"><%=cuenta%></td>
      </tr>
	    <tr>
		<td>Saldo</td>
		<td><%=saldo%></td>
	    </tr>
	</table>
	<p><a href="consultarSaldo.jsp">Retornar</a></p>
	<% } else { %>
	    <p>Mensaje: <%=mensaje%></p>
	    <p><a href="consultarSaldo.jsp">Retornar</a></p>
	<% } %>
    </body>
</html>
