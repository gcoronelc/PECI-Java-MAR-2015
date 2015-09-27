package pe.egcc.eureka.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.egcc.eureka.model.ClienteBean;
import pe.egcc.eureka.service.ClienteService;

@WebServlet({"/ClienteBuscarPage","/ClienteBuscar","/ClienteNuevo"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  String path = request.getServletPath();
	  if(path.equals("/ClienteBuscarPage")){
	    clienteBuscarPage(request,response);
	  } else if(path.equals("/ClienteBuscar")){
      clienteBuscar(request,response);
    }
	}

		
  private void clienteBuscarPage(HttpServletRequest request,
      HttpServletResponse response) 
          throws ServletException, IOException {
    // Distritos
    ClienteService clienteService = new ClienteService();
    request.setAttribute("comboDistritos", clienteService.getListaDistritos());
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("consultarClientes.jsp");
    rd.forward(request, response);
  }



  private void clienteBuscar(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    // Datos
    ClienteBean clienteBean = new ClienteBean();
    clienteBean.setCodigo(request.getParameter("codigo"));
    clienteBean.setPaterno(request.getParameter("paterno"));
    clienteBean.setMaterno(request.getParameter("materno"));
    clienteBean.setNombre(request.getParameter("nombre"));
    clienteBean.setDireccion(request.getParameter("direccion"));
    // Proceso
    clienteBean.establecerDatos();
    ClienteService clienteService = new ClienteService();
    List<ClienteBean> lista = clienteService.getClientes(clienteBean);
    // Json
    Gson gson = new Gson();
    String dataJson = gson.toJson(lista);
    // Retorno
    response.setContentType("text/plain; charset=UTF-8");
    response.getWriter().write(dataJson);
    response.getWriter().flush();
    response.getWriter().close();
  }

}
