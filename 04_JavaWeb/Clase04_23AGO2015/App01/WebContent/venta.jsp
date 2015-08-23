<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<h1>VENTA</h1>
<form id="form1" action="RegistrarVenta">
	<table>
		<tr>
			<td>Cliente</td>
			<td><input type="text" name="cliente" /></td>
		</tr>
		<tr>
			<td>Producto</td>
			<td><input type="text" name="producto" /></td>
		</tr>
		<tr>
			<td>Precio</td>
			<td><input type="text" name="precio" /></td>
		</tr>
		<tr>
			<td>Cantidad</td>
			<td><input type="text" name="cant" /></td>
		</tr>
	</table>
	<input class="boton_procesar" type="button" id="btnProcesar" value="Procesar"> 
	<input class="boton" type="reset" value="Limpiar">
</form>

<script type="text/javascript">

$("#btnProcesar").click(function(){
	var data = $("#form1").serialize();
	$.post("RegistrarVenta",data,function(response){
		$("#_CONTENIDO").html(response);
	});
});

</script>
