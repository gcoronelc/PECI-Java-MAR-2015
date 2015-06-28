<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<div>
	<h1>CONSULTAR CLIENTES</h1>
	<form id="form1">
		<table>
			<tr>
				<td>
				  Código<br /> 
				  <input type="text" name="codigo" maxlength="10" style="width: 50px;">
				</td>
				<td>
				  Paterno<br /> 
				  <input type="text" name="paterno" maxlength="30" style="width: 80px;">
				</td>
				<td>
				  Materno<br /> 
				  <input type="text" name="materno" maxlength="30" style="width: 80px;">
				</td>
				<td>
				  Nombre<br /> 
				  <input type="text" name="nombre" maxlength="30" style="width: 80px;">
				</td>
				<td>
          Distrito<br /> 
          <select name="direccion">
            <option value="">Seleccione...</option>
            <c:forEach items="${comboDistritos}" var="r">
              <option value="${r.value}">${r.label}</option>
            </c:forEach>
          </select>
        </td>
				<td>
				  <input type="button" id="btnConsultar" value="Consultar">
				</td>
			</tr>
		</table>
	</form>

	<div id="jqxgrid"></div>

  <div>
     <input type="button" value="Export to Excel" id='excelExport' /> 
     <input type="button" value="Export to XML" id='xmlExport' />
     <input type="button" value="Export to CSV" id='csvExport' /> <br/>
     <input type="button" value="Export to TSV" id='tsvExport' />
     <input type="button" value="Export to HTML" id='htmlExport' />
     <input type="button" value="Export to JSON" id='jsonExport' />
     <input type="button" value="Export to PDF" id='pdfExport' />
  </div>


</div>

<script type="text/javascript">
	var source = {
		localData : "[]",
		dataType : "json",
		dataFields : [ 
		   {name : 'codigo', type : 'string'}, 
		   {name : 'paterno', type : 'string'}, 
		   {name : 'materno', type : 'string'}, 
		   {name : 'nombre', type : 'string'}, 
		   {name : 'dni', type : 'string'}, 
		   {name : 'ciudad', type : 'string'}, 
		   {name : 'direccion', type : 'string'}, 
		   {name : 'telefono', type : 'string'}, 
		   {name : 'email', type : 'string'} 
		]
	};

	var dataAdapter = new $.jqx.dataAdapter(source);

	$("#jqxgrid").jqxGrid({
    width : '98%',
		pageable : true,
		source : dataAdapter,
		altRows : true,
		sortable : false,
		autorowheight : true,
		autoheight : true,
		altrows : true,
		columns : [ 
		  {text : 'CODIGO', dataField : 'codigo', width : 80}, 
		  {text : 'PATERNO', dataField : 'paterno', width : 150}, 
		  {text : 'MATERNO', dataField : 'materno', width : 150}, 
		  {text : 'NOMBRE', dataField : 'nombre', width : 150}, 
		  {text : 'DNI', dataField : 'dni', width : 100}, 
		  {text : 'CIUDAD', dataField : 'ciudad', width : 100}, 
		  {text : 'DIRECCION', dataField : 'direccion', width : 150}, 
		  {text : 'TELEFONO', dataField : 'telefono', width : 100}, 
		  {text : 'EMAIL', dataField : 'email', width : 200} 
	  ]
	});

	
	$("#excelExport").jqxButton();
	$("#xmlExport").jqxButton();
	$("#csvExport").jqxButton();
	$("#tsvExport").jqxButton();
	$("#htmlExport").jqxButton();
	$("#jsonExport").jqxButton();
	$("#pdfExport").jqxButton();
	
	
	$("#excelExport").click(function() {
		$("#jqxgrid").jqxGrid('exportdata', 'xls', 'jqxGrid');
	});
	$("#xmlExport").click(function() {
		$("#jqxgrid").jqxGrid('exportdata', 'xml', 'jqxGrid');
	});
	$("#csvExport").click(function() {
		$("#jqxgrid").jqxGrid('exportdata', 'csv', 'jqxGrid');
	});
	$("#tsvExport").click(function() {
		$("#jqxgrid").jqxGrid('exportdata', 'tsv', 'jqxGrid');
	});
	$("#htmlExport").click(function() {
		$("#jqxgrid").jqxGrid('exportdata', 'html', 'jqxGrid');
	});
	$("#jsonExport").click(function() {
		$("#jqxgrid").jqxGrid('exportdata', 'json', 'jqxGrid');
	});
	$("#pdfExport").click(function() {
		$("#jqxgrid").jqxGrid('exportdata', 'pdf', 'jqxGrid');
	});

	$("#btnConsultar").click(function() {
		var data = $("#form1").serialize();
		$.post("ClienteBuscar", data, function(dataJson) {

			source.localdata = dataJson, dataAdapter.dataBind();


		});
	});
</script>

