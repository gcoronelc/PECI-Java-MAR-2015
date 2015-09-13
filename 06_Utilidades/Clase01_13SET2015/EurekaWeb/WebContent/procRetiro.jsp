<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRAR RETIRO</title>
</head>
<body>
	<h1>REGISTRAR RETIRO</h1>

	<form id="form_data" class="form-horizontal" role="form">
		<div class="form-group">
			<label for="cuenta" class="col-lg-2 control-label">Cuenta</label>
			<div class="col-lg-10">
				<input type="text" 
				       class="form-control" 
				       name="cuenta"
				       id="cuenta"
					     placeholder="Número de cuenta">
			</div>
		</div>
		<div class="form-group">
      <label for="importe" class="col-lg-2 control-label">Importe</label>
      <div class="col-lg-10">
        <input type="number" 
               class="form-control" 
               name="importe"
               id="importe"
               placeholder="Importe a retirar">
      </div>
    </div>
		<div class="form-group">
			<label for="clave" class="col-lg-2 control-label">Contraseña</label>
			<div class="col-lg-10">
				<input type="password" class="form-control" 
				        name="clave" id="clave"
					placeholder="Contraseña">
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<button type="button" class="btn btn-default"
				        id="btnProcesar">Procesar</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
  $("#btnProcesar").click(function(){
	  var data = $("#form_data").serialize();
	  $.post("ProcCuentaRetiro",data,function(rpta){
		  if(rpta=="1"){
			  //alert("Proceso ok!");
			  BootstrapDialog.show({message: 'Proceso ok!'});
		  } else {
			  alert("Error!!!!!!!!!!!!!!!!!");
		  }
	  });
  });
</script>
</html>