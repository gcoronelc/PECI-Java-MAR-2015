<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/eureka.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/menu/menu.css"/>'>

<!-- BootStrap -->
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/bootstrap/css/bootstrap-dialog.min.css"/>'>

<title>EUREKA SPRING MAIN</title>
</head>
<body>
  <div class="_PAGE">
    <div class="_HEADER">
      <jsp:include page="header.jsp" />
    </div>
    <div class="_MENU">
      <jsp:include page="menu.jsp" />
    </div>
    <div class="_CONTENT" id="_CONTENT">
      
    </div>
    <div class="_FOOTER">
      Derechos Reservados @ Gustavo Coronel-2015<br/>
      <a style="color:white;" 
      href="http://gcoronelc.blogspot.pe/" target="_BLANK">Home Page</a>
    </div>
  </div>
  
  <div class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <div class="modal-body">
        <p>One fine body…</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
  
  
</body>

<script type="text/javascript" 
  src='<c:url value="/resources/jquery/jquery-2.1.4.min.js" />'></script>
<script type="text/javascript" 
  src='<c:url value="/resources/js/eureka.js" />'></script>
<script type="text/javascript" 
  src='<c:url value="/resources/menu/menu.js" />'></script>
<script type="text/javascript" 
  src='<c:url value="/resources/bootstrap/js/bootstrap.min.js" />'></script>
<script type="text/javascript" 
  src='<c:url value="/resources/bootstrap/js/bootstrap-dialog.min.js" />'></script>

</html>