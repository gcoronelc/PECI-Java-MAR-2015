<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${accion} CLIENTE</title>
</head>
<body>
  <h2>${accion} CLIENTE</h2>
  <form id="form2">
    <input type="hidden" name="accion" value="${accion}">
    <input type="hidden" name="codigo" value="${clienteBean.codigo}">
    <table>

      <tr>
        <td>Código: </td>
        <td>${clienteBean.codigo}</td>
      </tr>
      
      <tr>
        <td>Paterno: </td>
        <td>
          <c:if test="${accion == 'ELIMINAR'}">
            ${clienteBean.paterno }
          </c:if>
          <c:if test="${accion != 'ELIMINAR'}">
            <input type="text" size="50" name="paterno" value="${clienteBean.paterno}"/>
          </c:if>
        </td>
      </tr>      

      <tr>
        <td>Materno: </td>
        <td>
          <c:if test="${accion == 'ELIMINAR'}">
            ${clienteBean.materno }
          </c:if>
          <c:if test="${accion != 'ELIMINAR'}">
            <input type="text" size="50" name="materno" value="${clienteBean.materno}"/>
          </c:if>
        </td>
      </tr>     

      <tr>
        <td>Nombre: </td>
        <td>
          <c:if test="${accion == 'ELIMINAR'}">
            ${clienteBean.nombre }
          </c:if>
          <c:if test="${accion != 'ELIMINAR'}">
            <input type="text" size="50" name="nombre" value="${clienteBean.nombre}"/>
          </c:if>
        </td>
      </tr>     

      <tr>
        <td>DNI: </td>
        <td>
          <c:if test="${accion == 'ELIMINAR'}">
            ${clienteBean.dni }
          </c:if>
          <c:if test="${accion != 'ELIMINAR'}">
            <input type="text" size="50" name="dni" value="${clienteBean.dni}"/>
          </c:if>
        </td>
      </tr>
      
      <tr>
        <td>Ciudad: </td>
        <td>
          <c:if test="${accion == 'ELIMINAR'}">
            ${clienteBean.ciudad }
          </c:if>
          <c:if test="${accion != 'ELIMINAR'}">
            <input type="text" size="50" name="ciudad" value="${clienteBean.ciudad}"/>
          </c:if>
        </td>
      </tr>      

      <tr>
        <td>Dirección: </td>
        <td>
          <c:if test="${accion == 'ELIMINAR'}">
            ${clienteBean.direccion }
          </c:if>
          <c:if test="${accion != 'ELIMINAR'}">
            <input type="text" size="50" name="direccion" value="${clienteBean.direccion}"/>
          </c:if>
        </td>
      </tr>

      <tr>
        <td>Teléfono: </td>
        <td>
          <c:if test="${accion == 'ELIMINAR'}">
            ${clienteBean.telefono }
          </c:if>
          <c:if test="${accion != 'ELIMINAR'}">
            <input type="text" size="50" name="telefono" value="${clienteBean.telefono}"/>
          </c:if>
        </td>
      </tr>

      <tr>
        <td>Email: </td>
        <td>
          <c:if test="${accion == 'ELIMINAR'}">
            ${clienteBean.email }
          </c:if>
          <c:if test="${accion != 'ELIMINAR'}">
            <input type="text" size="50" name="email" value="${clienteBean.email}"/>
          </c:if>
        </td>
      </tr>

    </table>
    <br/>
    <a href="javascript: fnProcesar()" class="link_procesar">Procesar</a>
  
  </form>
</body>
</html>