<%-- 
    Document   : index
    Created on : 09/08/2015, 09:12:09 AM
    Author     : Profesor
--%>

<!-- Declaración -->
<%!
  private int n1 = 80;
  private int n2;

  private int doble(int n) {
    return n * n;
  }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <!-- Scriptlet -->
  <% 
  int t;
  t = doble(n1);
  n2 = t;
  %>
  <body>
    <h1>DEMO 01</h1>
    <p>n1 = <%= n1 %></p>
    <p>n2 = <%= n2 %></p>
    <h2>Otro caso</h2>
    <%
    out.print("n1=" + n1 + "<br/>");
    out.print("n2=" + n2 + "<br/>");
    %>
  </body>
</html>
