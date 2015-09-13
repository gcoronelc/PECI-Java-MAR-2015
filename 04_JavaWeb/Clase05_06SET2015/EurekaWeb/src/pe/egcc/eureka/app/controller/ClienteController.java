package pe.egcc.eureka.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.eureka.app.model.ClienteBean;
import pe.egcc.eureka.app.model.EmpleadoBean;
import pe.egcc.eureka.app.service.ClienteService;

@WebServlet({"/ClienteConsultar","/ClienteNuevo"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, 
	    HttpServletResponse response)
	    throws ServletException, IOException {
	  String servletPath = request.getServletPath();
	  if(servletPath.equals("/ClienteConsultar")){
	    clienteConsultar(request,response);
	  }
	  
	}

  private void clienteConsultar(HttpServletRequest request,
      HttpServletResponse response) 
          throws ServletException, IOException {
    String destino;
    try {
      // Datos
      ClienteBean clienteBean = new ClienteBean();
      clienteBean.setCodigo(request.getParameter("codigo"));
      clienteBean.setPaterno(request.getParameter("paterno"));
      clienteBean.setMaterno(request.getParameter("materno"));
      clienteBean.establecerDatos();
      // Proceso
      ClienteService clienteService = new ClienteService();
      List<ClienteBean> lista = clienteService.getClientes(clienteBean);
      request.setAttribute("lista", lista);
      destino = "conclientes2.jsp";
    } catch (Exception e) {
      request.setAttribute("mensaje", e.getMessage());
      destino = "mensaje.jsp";
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

}
