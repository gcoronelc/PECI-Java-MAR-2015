<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error/error_page.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>VENTA</h1>
  <form method="post" action="VentaController">
    <p>Precio: <input type="text" name="precio"></p>
    <p>Cantidad: <input type="text" name="cantidad"></p>
    <input type="submit" value="Procesar"/>
  </form>
  
  

  
  <c:if test="${ventaBean != null}">
    <h2>RESULTADO DE LA VENTA</h2>
    <table>
      <tr>
        <td>Precio:</td>
        <td>${ventaBean.precio}</td>
      </tr>
      <tr>
        <td>Cantidad:</td>
        <td>${ventaBean.cantidad}</td>
      </tr>
      <tr>
        <td>Importe:</td>
        <td>${ventaBean.importe}</td>
      </tr>
      <tr>
        <td>Impuesto:</td>
        <td>${ventaBean.impuesto}</td>
      </tr>
      <tr>
        <td>Total:</td>
        <td>${ventaBean.total}</td>
      </tr>
    </table>
  </c:if>
</body>
</html>