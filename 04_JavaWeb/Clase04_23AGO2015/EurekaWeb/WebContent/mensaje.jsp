<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<h1>MENSAJE</h1>
<c:if test="${mensaje != null}">
	<p class="mensaje">${mensaje}</p>
</c:if>
<c:if test="${error != null}">
	<p class="error">${error}</p>
</c:if>
