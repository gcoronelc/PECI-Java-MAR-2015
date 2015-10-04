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
<h1>CONSULTAR CLIENTES</h1>
<form id="form1">
  <table>
    <tr>
      <td>Código</td>
      <td>Paterno</td>
      <td>Materno</td>
      <td rowspan="2">
        <input type="button" id="btnConsultar"
          class="boton_procesar" value="Consultar"/>
      </td>
    </tr>
    <tr>
      <td><input type="text" name="codigo" size="10" /></td>
      <td><input type="text" name="paterno" /></td>
      <td><input type="text" name="materno" /></td>
    </tr>
  </table>
</form>
</div>
<div id="divClientes">
</div>
</body>
<script type="text/javascript">

  $("#btnConsultar").click(function(){
	  var data = $("#form1").serialize();
	  $.post("clienteconsultar.htm",data,function(response){
		  $("#divClientes").html(response);
	  });
  });


</script>
</html>