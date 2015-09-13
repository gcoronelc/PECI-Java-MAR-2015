try {

	// Usando el archivo JRXML y el objeto Connection
	Connection cn = DSMySQL.getConnection();
	Map pars = new HashMap();
	JasperReport rep = JasperCompileManager.compileReport(MainView.class.getResourceAsStream("reports/ListaClientes.jrxml"));
	JasperPrint print = JasperFillManager.fillReport(rep, pars, cn);

	// Visualizando el Reporte
	JasperViewer viewer = new JasperViewer(print, false);
	viewer.setTitle("Mi Reporte");
	viewer.setVisible(true);

	//JasperViewer.viewReport(print);
	
} catch (Exception ex) {
	JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
}




try {

	// Usando una colección de datos
	IClienteDAO dao = DAOFactory.getDAOFactory().getClienteDAO();
	List lista = dao.consultarTodos();
	JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(lista);
	Map pars = new HashMap();
	JasperReport rep = JasperCompileManager.compileReport(MainView.class.getResourceAsStream("reports/report1.jrxml"));
	JasperPrint print = JasperFillManager.fillReport(rep, pars, data);

	// Visualizando el Reporte
	JasperViewer viewer = new JasperViewer(print, false);
	viewer.setTitle("Mi Reporte");
	viewer.setVisible(true);

	//JasperViewer.viewReport(print);
	
} catch (Exception ex) {
	JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
}
