<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Operaciones</title>
    </head>
    
    <body>
	<h1>Operaciones</h1>
	<h2>Error</h2>
	<p>Mensaje: <%= exception.getMessage()%></p>
	<p><a href="operaciones.html">Retornar</a></p>
    </body>
    <% double igv = Double.parseDouble(s)  %>
</html>
