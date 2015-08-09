<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pago a Trabajadores</title>
</head>
<body>
	<h1>PAGOS A TRABAJADORES</h1>
	<form method="post" action="PagoController">
		<p>
			Horas Trabajadas: <input type="text" name="horasTrabajadas">
		</p>
		<p>
			Días Trabajados: <input type="text" name="diasTrabajados">
		</p>
		<p>
			Pago por Hora: <input type="text" name="pagoPorHora">
		</p>
		<input type="submit" value="Procesar" />
	</form>

	<c:if test="${pagoBean != null}">
		<h2>RESULTADO DEL CALCULO DEL PAGO</h2>
		<table>
			<tr>
				<td>Horas Trabajadas:</td>
				<td>${pagoBean.horasTrabajadas}</td>
			</tr>
			<tr>
				<td>Días Trabajados:</td>
				<td>${pagoBean.diasTrabajados}</td>
			</tr>
			<tr>
				<td>Pago por Hora:</td>
				<td>${pagoBean.pagoPorHora}</td>
			</tr>
			<tr>
				<td>Importe:</td>
				<td>${pagoBean.importe}</td>
			</tr>
			<tr>
				<td>Impuesto:</td>
				<td>${pagoBean.impuesto}</td>
			</tr>
			<tr>
				<td>Total:</td>
				<td>${pagoBean.total}</td>
			</tr>
		</table>
	</c:if>
</body>
</html>