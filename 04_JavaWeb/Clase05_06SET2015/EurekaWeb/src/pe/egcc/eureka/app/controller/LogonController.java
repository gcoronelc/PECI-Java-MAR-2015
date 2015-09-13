package pe.egcc.eureka.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.eureka.app.model.EmpleadoBean;
import pe.egcc.eureka.app.service.LogonService;

@WebServlet({"/IngresoSistema","/SalirSistema"})
public class LogonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, 
	    HttpServletResponse response)
	    throws ServletException, IOException {
	  String servletPath = request.getServletPath();
	  if(servletPath.equals("/IngresoSistema")){
	    ingresoSistema(request,response);
	  }
	}

  private void ingresoSistema(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    String respuesta = "";
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      LogonService logonService = new LogonService();
      EmpleadoBean empleadoBean = logonService.verificarUsuario(usuario, clave);
      request.getSession().setAttribute("usuario", empleadoBean);
      respuesta = "0"; // Ok
    } catch (Exception e) {
      respuesta = "1"; // Error
      e.printStackTrace();
    }
    // Enviar respuesta
    response.setContentType("text/plain"); 
    PrintWriter out = response.getWriter(); 
    out.print(respuesta); 
    out.flush();
    out.close(); 
  }
}
