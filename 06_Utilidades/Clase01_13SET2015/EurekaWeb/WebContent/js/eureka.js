function cargarPagina(pagina) {
	$("#_CONTENT").load(pagina);
}

function repoTodosClientes() {
	var html = "<object width='770' height='400' data='RepoTodosClientes'></object>";
	$("#_CONTENT").html(html);
}

