<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>TABLA DE MULTIPLICAR</h1>
	
	<form method="post" action="index.jsp">
		<p>Número de tabla</p>
		<select name="numero">
			<option value="0">Seleccione</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
      <option value="8">8</option>
      <option value="9">9</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
		</select>
		<input type="submit" value="Procesar">
	</form>

  <c:if test="${param.numero != null}">
    <h2>Table del número: ${param.numero}</h2>
    <table>
    
      <c:forEach begin="1" end="12" var="n">
        <c:set var="r" value="${n * param.numero}" />
	      <tr>
	        <td>${n}</td>
	        <td>*</td>
	        <td>${param.numero}</td>
	        <td>=</td>
	        <td>${r}</td>
	      </tr>
      </c:forEach>
      
    </table>
  </c:if>
  
</body>
</html>