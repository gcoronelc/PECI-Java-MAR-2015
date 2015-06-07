package pe.egcc.eureka.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.eureka.model.EmpleadoBean;
import pe.egcc.eureka.service.LogonService;

@WebServlet({"/LogonIngreso","/LogonSalir"})
public class LogonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  String path = request.getServletPath();
	  if(path.equals("/LogonIngreso")){
	    logonIngreso(request,response);
	  } else if(path.equals("/LogonSalir")){
	    logonSalir(request,response);
    }
	}

  private void logonIngreso(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    String destino;
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      LogonService logonService = new LogonService();
      EmpleadoBean bean = logonService.verificarUsuario(usuario, clave);
      destino = "main.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    RequestDispatcher rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

  private void logonSalir(HttpServletRequest request,
      HttpServletResponse response) {
    // TODO Auto-generated method stub
    
  }
}
