package pe.egcc.eureka.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pe.egcc.eureka.app.model.ClienteBean;
import pe.egcc.eureka.app.model.EmpleadoBean;
import pe.egcc.eureka.app.service.ClienteService;
import pe.egcc.eureka.app.util.EurekaUtil;

@WebServlet({ "/ClienteConsultar", "/ClienteListado", 
    "/ClienteNuevo","/ClienteEditar", "/ClienteEliminar",
    "/ClienteGrabar","/ClienteToExcel"    })
public class ClienteController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    String servletPath = request.getServletPath();
    if (servletPath.equals("/ClienteConsultar")) {
      clienteConsultar(request, response, "conclientes2.jsp");
    } else if (servletPath.equals("/ClienteListado")) {
      clienteConsultar(request, response, "listadoClientes.jsp");
    } else if (servletPath.equals("/ClienteNuevo")) {
      cargarCliente(request, response, EurekaUtil.EDICION_NUEVO);
    } else if (servletPath.equals("/ClienteEditar")) {
      cargarCliente(request, response, EurekaUtil.EDICION_EDITAR);
    } else if (servletPath.equals("/ClienteEliminar")) {
      cargarCliente(request, response, EurekaUtil.EDICION_ELIMINAR);
    } else if (servletPath.equals("/ClienteGrabar")) {
      clienteGrabar(request, response);
    } else if (servletPath.equals("/ClienteToExcel")) {
      clienteToExcel(request, response);
    }

  }

  private void clienteToExcel(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.ms-excel");
    PrintWriter out = response.getWriter();
    out.println("Tipo\tQ1\tQ2\tQ3\tQ4\tTotal");
    out.println("Manzanas\t78\t87\t92\t29\t=SUMA(B2:E2)");
    out.println("Naranjas\t77\t86\t93\t30\t=SUMA(B3:E3)");
    out.flush();
    out.close();
  }

  private void clienteGrabar(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    Map<String,Object> rpta = new HashMap<String, Object>();
    try {
      // Datos
      ClienteBean clienteBean = new ClienteBean();
      clienteBean.setCodigo(request.getParameter("codigo"));
      clienteBean.setPaterno(request.getParameter("paterno"));
      clienteBean.setMaterno(request.getParameter("materno"));
      clienteBean.setNombre(request.getParameter("nombre"));
      clienteBean.setDni(request.getParameter("dni"));
      clienteBean.setDireccion(request.getParameter("direccion"));
      clienteBean.setCiudad(request.getParameter("ciudad"));
      clienteBean.setTelefono(request.getParameter("telefono"));
      clienteBean.setEmail(request.getParameter("email"));
      String accion = request.getParameter("accion");
      // Proceso
      ClienteService clienteService;
      clienteService = new ClienteService();
      switch (accion) {
      case EurekaUtil.EDICION_NUEVO:
        clienteService.insertar(clienteBean);
        rpta.put("rpta", 1);
        rpta.put("mensaje", "El cliente se ha registrado con exito.");
        break;
      case EurekaUtil.EDICION_EDITAR:
        clienteService.actualizar(clienteBean);
        rpta.put("rpta", 1);
        rpta.put("mensaje", "Los datos del cliente fueron actualizados con exito.");
        break;
      case EurekaUtil.EDICION_ELIMINAR:
        clienteService.eliminar(clienteBean.getCodigo());
        rpta.put("rpta", 1);
        rpta.put("mensaje", "Se procedio a eliminar el cliente con exito.");
        break;
      }
      
    } catch (Exception e) {
      rpta.put("rpta", 0);
      rpta.put("mensaje", "ERROR: " + e.getMessage());
    }
    
    Gson gson = new Gson();
    String gsonRpta = gson.toJson(rpta);
    
    response.setCharacterEncoding("utf-8");
    response.setContentType("application/json");
    Writer out = response.getWriter();
    out.write(gsonRpta);
    out.flush();
    out.close();
  }

  private void cargarCliente(HttpServletRequest request,
      HttpServletResponse response, String accion) throws ServletException,
      IOException {
    ClienteBean clienteBean = null;
    switch (accion) {
    case EurekaUtil.EDICION_NUEVO:
      clienteBean = new ClienteBean();
      clienteBean.setCodigo("none");
      break;
    case EurekaUtil.EDICION_EDITAR:
    case EurekaUtil.EDICION_ELIMINAR:
      String codigo = request.getParameter("codigo");
      ClienteService clienteService = new ClienteService();
      clienteBean = clienteService.getCliente(codigo);
      break;
    }

    request.setAttribute("accion", accion);
    request.setAttribute("clienteBean", clienteBean);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("formCliente.jsp");
    rd.forward(request, response);
    
  }

  private void clienteConsultar(HttpServletRequest request,
      HttpServletResponse response, String target) throws ServletException,
      IOException {
    String destino;
    HttpSession session = request.getSession();
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
      session.setAttribute("listaClientes", lista);
      request.setAttribute("lista", lista);
      destino = target;
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
