function cargarPagina(pagina) {
	var p = pagina.search(".htm");
	var url;
	if(p > -1){
		url = pagina
	} else {
		url ="loadPage.htm?page=" + pagina;
	}
	$("#_CONTENT").load(url);
}

function repoTodosClientes() {
	var html = "<object width='770' height='400' data='RepoTodosClientes'></object>";
	$("#_CONTENT").html(html);
}

