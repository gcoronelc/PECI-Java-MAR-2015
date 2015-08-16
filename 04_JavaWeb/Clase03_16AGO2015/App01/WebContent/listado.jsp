<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Insert title here</title>
</head>
<body>
  <div style="width: 100%">
  	<jsp:include page="menu.jsp"/>
  </div>
  <div style="width: 100%;">
  	<h1>LISTADO</h1>
  	<table>
  	
  	 <tr class="rowH">
  	   <td>CLIENTE</td>
  	   <td>PRODUCTO</td>
  	   <td>PRECIO</td>
  	   <td>CANTIDAD</td>
  	   <td>IMPORTE</td>
  	 </tr>
  	
  	 <c:set var="s" value="rowB1" />
  	 <c:forEach items="${sessionScope.ventasService.lista}" var="r">
  	   <tr class="${s}">
  	     <td>${r.cliente}</td>
  	     <td>${r.producto}</td>
  	     <td>${r.precio}</td>
  	     <td>${r.cant}</td>
  	     <td>${r.importe}</td>
  	   </tr>
       <c:choose>
         <c:when test="${s=='rowB1'}">
           <c:set var="s" value="rowB2" />
         </c:when>
         <c:otherwise>
           <c:set var="s" value="rowB1" />
         </c:otherwise>
       </c:choose>
  	 </c:forEach>
  	</table>
  </div>
</body>
</html>