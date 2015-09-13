<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DEMO 01</title>
</head>
<body>
  <h1>DEMO 01</h1>

  <c:forEach var="n" begin="1" end="6" >  
    <h${n}>Hola Todos</h${n}>
  </c:forEach>
  
</body>
</html>