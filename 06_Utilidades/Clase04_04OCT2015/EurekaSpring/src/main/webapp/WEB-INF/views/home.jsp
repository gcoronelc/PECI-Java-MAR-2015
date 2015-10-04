<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/eureka.css"/>'>
<title>INGRESO AL SISTEMA</title>
<style type="text/css">
#_LOGIN{
  background-color: white;
  color: #2E2E2E;
  width: 300px;
  margin: 10px auto;
  padding: 5px;
}
</style>
</head>
<body>
  <div id="_LOGIN">
    <img alt="" src="img/logo.gif">
    <h1>INGRESO AL SISTEMA</h1>
    <form id="form1">
      <table>
        <tr>
          <td>Usuario</td>
          <td><input type="text" name="usuario"/></td>
        </tr>
        <tr>
          <td>Clave</td>
          <td><input type="password" name="clave"/></td>
        </tr>
      </table>
      <input type="button" id="btnProcesar"  
            class="boton_procesar"
            value="Ingresar al Sistema"/>
    </form>
  </div>
</body>
<script type="text/javascript" src=></script>
<script type="text/javascript" src='<c:url 
  value="/resources/jquery/jquery-2.1.4.min.js" />'></script>
<script type="text/javascript">

  $("#btnProcesar").click(function(){
    var data = $("#form1").serialize();
    $.post("ingresoSistema.gustavo",data,function(texto){
      if(texto == '1'){
        window.location.href = "loadPage.htm?page=main";
      } else {
        alert("Datos incorrectos.");
      }  
    });
  });
  
</script>
</html>
