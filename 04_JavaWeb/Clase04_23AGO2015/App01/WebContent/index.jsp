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
  <div class="_PAGE">
    <div class="_MENU">
		  <jsp:include page="menu.jsp" />
		</div>
		<div class="_CONTENIDO" id="_CONTENIDO">
		  <p>${sessionScope.inicio}</p>
		</div>
		<div class="_PIE">
		  Derechos Reservados @ EGCC-2015
		</div>
	</div>
</body>
<script type="text/javascript" src="jquery/jquery-2.1.4.min.js""></script>
<script type="text/javascript" src="js/app.js""></script>
</html>