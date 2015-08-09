<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
  // Variables
  int num1;
  int num2;
  int suma;
  // Datos
  num1 = Integer.parseInt(request.getParameter("num1"));
  num2 = Integer.parseInt(request.getParameter("num2"));
  // Proceso
  suma = num1 + num2;
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUMA</title>
</head>
<body>
  <h1>SUMA</h1>
  <!-- Mostrar datos -->
  <p>Número 1: <%= num1 %></p>
  <p>Número 2: <%= num2 %></p>
  <!-- Resultado -->
  <p>Suma: <%= suma %></p>
  <a href="index.html">Otro calculo</a>
</body>
</html>