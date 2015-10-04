<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MANTENIMIENTO DE CLIENTES</title>
</head>
<body>
  <h1>MANTENIMIENTO DE CLIENTES</h1>
  <form id="form1">
	  <table>
	    <tr>
	     <td>
	       <table>
	         <tr>
	           <td>Código</td>
	           <td>Paterno</td>
	           <td>Materno</td>
	           <td>Nombre</td>
	         </tr>
	         <tr>
	           <td><input type="text" name="codigo" size="10" /></td>
	           <td><input type="text" name="paterno" size="12" /></td>
	           <td><input type="text" name="materno" size="12" /></td>
	           <td><input type="text" name="nombre" size="12" /></td>
           </tr>
	       </table>
	     </td>
	     <td valign="bottom">
	       <a href="javascript: fnBuscar()" title="Buscar clientes">
	         <img alt="" src="img/search.png">
	       </a>
	       <a href="ClienteToExcel" title="Exportar a Excel">
           <img alt="" src="img/excel.png">
         </a>
         <a href="#" title="Exportar a PDF">
           <img alt="" src="img/pdf.png">
         </a>
         <a href="#" title="Exportar a CSV">
           <img alt="" src="img/csv.png">
         </a>
	       <a href="javascript: fnNuevo()" title="Nuevo cliente">
           <img alt="" src="img/new.png">
         </a>
	     </td>
	    </tr>
	  </table>
  </form>
  <div id="workDiv">
  </div>
</body>
<script type="text/javascript">

  function fnBuscar(){
	  var data = $("#form1").serialize();
	    $.post("ClienteListado",data,function(response){
	      $("#workDiv").html(response);
	    });
  }
  
  function fnNuevo(){
	  $.post("ClienteNuevo",function(response){
	    $("#workDiv").html(response);
	  });
	}
  
  function fnEditar(codigo){
	  var data = "codigo=" + codigo;
    $.post("ClienteEditar",data,function(response){
      $("#workDiv").html(response);
    });
  }

  function fnEliminar(codigo){
	    var data = "codigo=" + codigo;
	    $.post("ClienteEliminar",data,function(response){
	      $("#workDiv").html(response);
	    });
	}  
  
  function fnProcesar(){
      var data = $("#form2").serialize();
      $.post("ClienteGrabar",data,function(response){
        alert(response.mensaje);
      });
  }

  function fnToExcel(){
      $.get("ClienteToExcel");
  }
  
  
</script>
</html>