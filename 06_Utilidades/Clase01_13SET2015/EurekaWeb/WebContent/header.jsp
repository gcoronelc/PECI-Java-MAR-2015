<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<div style="width:250px; display: inline-block;">
  <img src="img/logo.gif" />
</div>
<div style="width:250px; display: inline-block;">
  Usuario: <b>${sessionScope.usuario.nombre}
  ${sessionScope.usuario.paterno}</b>
</div>
<div style="width:250px; display: inline-block;">
  <a class="link_procesar" href="#">Salir del Sistema</a>
</div>