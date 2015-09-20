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
<div>
<h1>REPORTE DE CLIENTES</h1>
<form id="form1">
  <table>
    <tr>
      <td>Sucursal</td>
      <td>Moneda</td>
      <td rowspan="2">
        <input type="button" id="btnConsultar"
          class="boton_procesar" value="Consultar"/>
      </td>
    </tr>
    <tr>
      <td><input type="text" name="sucursal" size="10" /></td>
      <td><input type="text" name="moneda" size="10" /></td>
    </tr>
  </table>
</form>
</div>
<div id="divReporte" style="width: 770px; height: 400px;">
</div>
</body>
<script type="text/javascript">

  $("#btnConsultar").click(function(){
	  var data = $("#form1").serialize();
	  var url = "RepoResumen?" + data;
	  alert(url);
	  var html = "<object width='770' height='400' data='" 
		  + url + "'></object>";
	  $("#divReporte").html(html);
  });


</script>
</html>