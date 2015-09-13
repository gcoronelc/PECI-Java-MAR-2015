package pe.egcc.eureka.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pe.egcc.eureka.app.dao.AccesoDB;
import pe.egcc.eureka.app.model.ClienteBean;
import pe.egcc.eureka.app.service.ClienteService;
import pe.egcc.eureka.app.util.EurekaUtil;


@WebServlet({ "/RepoTodosClientes", "/RepoClientes" })
public class ReporteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String path = request.getServletPath();
	  if(path.equals("/RepoTodosClientes")){
	    repoTodosClientes(request,response);
	  } else if(path.equals("/RepoClientes")){
      repoClientes(request,response);
    }
	}

  private void repoClientes(HttpServletRequest request,
      HttpServletResponse response) {
    try {
      // Parametros
      ClienteBean clienteBean = new ClienteBean();
      clienteBean.setCodigo(request.getParameter("codigo"));
      clienteBean.setPaterno(request.getParameter("paterno"));
      clienteBean.setMaterno(request.getParameter("materno"));
      clienteBean.establecerDatos();
      // Consultar los datos
      ClienteService clienteService = new ClienteService();
      List<ClienteBean> lista = clienteService.getClientes(clienteBean);     
      JRBeanCollectionDataSource data;
      data = new JRBeanCollectionDataSource(lista);
      // Parametros del reporte
      Map pars = new HashMap();
      String logoFile = "/pe/egcc/eureka/app/img/logo.gif";
      InputStream logoStrean = getClass().getResourceAsStream(logoFile);
      pars.put("LOGO", logoStrean);
      // Reporte
      String repoFile = "/pe/egcc/eureka/app/reports/repoClientes02.jrxml";
      InputStream repoJRXML = getClass().getResourceAsStream(repoFile);
      JasperReport repoComp = JasperCompileManager.compileReport(repoJRXML);
      byte[] bytes = JasperRunManager.runReportToPdf(repoComp, pars, data);      
      // Enviando la data al browser
      response.setContentType("application/pdf");
      response.setContentLength(bytes.length);
      ServletOutputStream out = response.getOutputStream();
      out.write(bytes,0,bytes.length);
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void repoTodosClientes(HttpServletRequest request,
      HttpServletResponse response) {
    try {
      // Usando el archivo JRXML y el objeto Connection
      Connection cn = AccesoDB.getConnection();
      Map pars = new HashMap();
      String repoFile = "/pe/egcc/eureka/app/reports/repoClientes01.jrxml";
      InputStream repoJRXML = getClass().getResourceAsStream(repoFile);
      JasperReport repoComp = JasperCompileManager.compileReport(repoJRXML);
      byte[] bytes = JasperRunManager.runReportToPdf(repoComp, pars, cn);
      // Enviando la data al browser
      response.setContentType("application/pdf");
      response.setContentLength(bytes.length);
      ServletOutputStream out = response.getOutputStream();
      out.write(bytes,0,bytes.length);
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
