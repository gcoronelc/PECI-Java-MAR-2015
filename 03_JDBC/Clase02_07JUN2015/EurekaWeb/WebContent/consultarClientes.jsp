<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<div>
<h1>CONSULTAR CLIENTES</h1>
<form id="form1">
	<table>
	  <tr>
	    <td>
	     Código<br/>
	     <input type="text" name="codigo" width="40">
	    </td>
      <td>
       Paterno<br/>
       <input type="text" name="paterno" width="40">
      </td>
      <td>
       Materno<br/>
       <input type="text" name="materno" width="40">
      </td>
      <td>
       Nombre<br/>
       <input type="text" name="nombre" width="40">
      </td>
	    <td>
       <input type="button" id="btnConsultar" value="Consultar">
      </td>
	  </tr>
	</table>
</form>
</div>
<div id="divResultado" style="display: none;">

  <div id="jqxgrid"></div>

</div>

<script type="text/javascript">

	var source =
	{
	    localData: "[]",
	    dataType: "json",
	    dataFields:
	    [
	        { name: 'codigo', type: 'string' },
	        { name: 'paterno', type: 'string' },
	        { name: 'materno', type: 'string' },
	        { name: 'nombre', type: 'string' },
	        { name: 'dni', type: 'string' },
	        { name: 'ciudad', type: 'string' },
	        { name: 'direccion', type: 'string' },
	        { name: 'telefono', type: 'string' },
	        { name: 'email', type: 'string' }
	    ]
	};

 var dataAdapter = new $.jqx.dataAdapter(source);

 $("#jqxgrid").jqxGrid(
   {
       width: 800,
       pageable: true,
       source: dataAdapter,
       altRows: true,
       sortable: true,
       autorowheight: true,
       autoheight: true,
       altrows: true,
       columns: [
         { text: 'CODIGO', dataField: 'codigo', width: 80 },
         { text: 'PATERNO', dataField: 'paterno', width: 100 },
         { text: 'MATERNO', dataField: 'materno', width: 100 },
         { text: 'NOMBRE', dataField: 'nombre', width: 100 },
         { text: 'DNI', dataField: 'dni', width: 80 },
         { text: 'CIUDAD', dataField: 'ciudad', width: 100 },
         { text: 'DIRECCION', dataField: 'direccion', width: 150 },
         { text: 'TELEFONO', dataField: 'telefono', width: 100 },
         { text: 'EMAIL', dataField: 'email', width: 200 }
       ]
   });

  $("#btnConsultar").click(function(){
	  var data = $("#form1").serialize();
	  $.post("ClienteBuscar",data,function(dataJson){

	  	/*
	  	var tmpSource = $("#jqxgrid").jqxGrid("source");
	  	tmpSource._source.localData = dataJson
	    $("#jqxgrid").jqxGrid("source", tmpSource);
	    */

	    
	  	source.localdata = dataJson,
      dataAdapter.dataBind();
      
	  	$("#divResultado").show();

	  });
  });
</script>

