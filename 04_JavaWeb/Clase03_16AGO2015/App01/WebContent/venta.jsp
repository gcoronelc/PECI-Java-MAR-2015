<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 100%">
		<jsp:include page="menu.jsp" />
	</div>
	<div style="width: 100%;">
		<h1>VENTA</h1>
		<form method="post" action="RegistrarVenta">
		  <table>
		    <tr>
		      <td>Cliente</td>
		      <td><input type="text" name="cliente"/></td>
		    </tr>
		    <tr>
          <td>Producto</td>
          <td><input type="text" name="producto"/></td>
        </tr>
        <tr>
          <td>Precio</td>
          <td><input type="text" name="precio"/></td>
        </tr>
        <tr>
          <td>Cantidad</td>
          <td><input type="text" name="cant"/></td>
        </tr>
		  </table>
		  <input class="boton_procesar" type="submit" value="Procesar">
		  <input class="boton" type="reset" value="Limpiar">
		</form>
	</div>
</body>
</html>