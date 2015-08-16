<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div>
	 <h1>RESUMEN</h1>
	 <p>Cantidad: ${cant}</p>
	 <p>Precio promedio: ${precio}</p>
	 <p>Importe total: ${importe}</p>
	</div>
</body>
</html>