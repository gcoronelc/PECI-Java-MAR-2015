<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>CONSULTAR MOVIMIENTOS</h1>
  <form id="form1">
    <label>Cuenta:</label>
    <input type="text" name="cuenta" />
    <input type="button" value="Consultar"
            class="boton_procesar"
            id="btnConsultar" />
  </form>
  
  <div id="ResultadoConsulta"></div>

 
</body>
<script type="text/javascript">

  $("#btnConsultar").click(function(){
	  var data = $("#form1").serialize();	  
	  $.post("ConCuentaMovimientos",data,function(dataJson){
		  
		  var html = "<table border='1'> <thead> ";
		  html += "<tr><th>NRO.MOV.</th><th>TIPO</th><th>FECHA</th><th>IMPORTE</th></tr>";
		  html += "</thead><body>";
		 
		  
		  for(var i = 0; i < dataJson.length; i++){
			  html += "<tr>";
			  html += "<td>" + dataJson[i].NROMOV + "</td>";
			  html += "<td>" + dataJson[i].TIPO + "</td>";
			  html += "<td>" + dataJson[i].FECHA + "</td>";
			  html += "<td>" + dataJson[i].IMPORTE + "</td>";
			  html += "</tr>";
		  }
		 
		  html += "</body></table>"
		 
		 //</table>";
		 $("#ResultadoConsulta").html(html);
		 //$('#tablaData').bootstrapTable();
	  });
  });

</script>
</html>