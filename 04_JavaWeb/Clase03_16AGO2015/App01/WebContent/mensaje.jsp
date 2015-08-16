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
  	<h1>MENSAJE</h1>
  	<c:if test="${mensaje != null}">
  	 <p class="mensaje">${mensaje}</p>
  	</c:if>
  	<c:if test="${error != null}">
     <p class="error">${error}</p>
    </c:if>
  </div>
</body>
</html>