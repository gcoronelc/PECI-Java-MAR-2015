<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTADO DE CLIENTES</title>
</head>
<body>
  <h2>LISTADO DE CLIENTES</h2>
  <table border="1">
  <tr>
    <th>ACCION</th>
    <th>CODIGO</th>
    <th>PATERNO</th>
    <th>MATERNO</th>
    <th>NOMBRE</th>
    <th>DNI</th>
    <th>EMAIL</th>
  </tr>

  <c:forEach items="${lista}" var="r">
  <tr>
    <td>
      <a href="javascript: fnEditar('${r.codigo}')" title="Editar cliente ${r.codigo}.">
        <img alt="" src="img/edit.png">
      </a>
      <a href="javascript: fnEliminar('${r.codigo}')" title="Eliminar cliente ${r.codigo}.">
        <img alt="" src="img/delete.png">
      </a>
    </td>
    <td>${r.codigo}</td>
    <td>${r.paterno}</td>
    <td>${r.materno}</td>
    <td>${r.nombre}</td>
    <td>${r.dni}</td>
    <td>${r.email}</td>
  </tr>
  </c:forEach>
  
  </table>
</body>
</html>