<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page errorPage="paginaError.jsp" %>
<jsp:useBean id="myMath" class="logic.MyMath" scope="page"/>
<jsp:setProperty name="myMath" property="*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Operaciones</title>
    </head>
    
    <body>
	<h1>Operaciones</h1>
	<table width="268">
	    <tr>
		<td width="96">Número 1</td>
		<td width="160"><jsp:getProperty name="myMath" property="num1"/></td>
	    </tr>
	    <tr>
		<td>Número 2</td>
		<td><jsp:getProperty name="myMath" property="num2"/></td>
	    </tr>
	    <tr>
		<td>Suma</td>
		<td><jsp:getProperty name="myMath" property="suma"/></td>
	    </tr>
	    <tr>
		<td>Producto</td>
		<td><jsp:getProperty name="myMath" property="producto"/></td>
	    </tr>
	</table>
	<p><a href="operaciones.html">Retornar</a></p>
    </body>
</html>
