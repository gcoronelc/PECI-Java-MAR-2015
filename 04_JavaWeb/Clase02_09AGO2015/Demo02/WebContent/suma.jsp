<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%!
  int num1;
  int num2;
  int suma;
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUMA</title>
</head>
<body>
  <h1>SUMA</h1>
  <!-- Captura de datos -->
  <%
    num1 = Integer.parseInt(request.getParameter("num1"));
    num2 = Integer.parseInt(request.getParameter("num2"));
  %>
  <!-- Mostrar datos -->
  <p>Número 1: <%= num1 %></p>
  <p>Número 2: <%= num2 %></p>
  <% Thread.currentThread().sleep(1000); %>
  <!-- Proceso -->
  <% suma = num1 + num2; %>
  <!-- Resultado -->
  <p>Suma: <% out.print(suma); %></p>
  <a href="index.html">Otro calculo</a>
</body>
</html>