<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1>REGISTRAR RETIRO</h1>
	<form id="form1">
	  <table>
	    <tr>
	      <td>Cuenta:</td>
	      <td><input type="text" name="cuenta" placeholder="Cuenta"/></td>
	    </tr>
	    <tr>
	      <td>Importe:</td>
	      <td><input type="number" name="importe" value="" placeholder="Importe" /></td>
	    </tr>
	    <tr>
	      <td>Clave:</td>
	      <td><input type="password" name="clave" value="" placeholder="Clave"/></td>
	    </tr>  
	  </table>
	  <input type="button" name="btnProcesar" id="btnProcesar" value="Procesar"/>
	</form>
	<div id="jqxNotificationError"><div></div></div>
	<div id="jqxNotificationInfo"><div></div></div>
</body>
<script type="text/javascript">

  $("#jqxNotificationError").jqxNotification({ width: "50%", position: "top-right", opacity: 0.9,
     autoOpen: false, animationOpenDelay: 800, autoClose: false, template: "error"});
  $("#jqxNotificationInfo").jqxNotification({ width: "50%", position: "top-right", opacity: 0.9,
    autoOpen: false, animationOpenDelay: 800, autoClose: false, template: "info"});

  $("#btnProcesar").click(function(){
	  var data = $("#form1").serialize();
	  $.post("CuentaRetiro",data,function(objJson){
		  if(objJson.cod == 1){
		  	$('#jqxNotificationInfo').find('div').first().text('Proceso ejecutado correctamente.');      
        $('#jqxNotificationInfo').jqxNotification('open'); 
		  } else {
		  	$('#jqxNotificationError').find('div').first().text('ERROR: ' + objJson.error);      
        $('#jqxNotificationError').jqxNotification('open'); 
		  }
	  });
  });

</script>
</html>