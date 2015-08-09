package pe.egcc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.model.VentaBean;
import pe.egcc.app.service.VentaService;


@WebServlet("/VentaController")
public class VentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String destino;
	  try{
  	  // Datos
  	  double precio = Double.parseDouble(request.getParameter("precio"));
  	  int cantidad = Integer.parseInt(request.getParameter("cantidad"));
  	  // Proceso
  	  VentaBean ventaBean = new VentaBean();
  	  ventaBean.setPrecio(precio);
  	  ventaBean.setCantidad(cantidad);
  	  VentaService ventaService = new VentaService();
  	  ventaService.procesar(ventaBean);
  	  request.setAttribute("ventaBean", ventaBean);
  	  destino = "index.jsp";
	  } catch(Exception e){
	    destino = "error/error_control.jsp";
	    request.setAttribute("clase", e.getClass());
	    request.setAttribute("mensaje", e.getMessage());
	  }
	  // Reporte
	  RequestDispatcher rd;
	  rd = request.getRequestDispatcher(destino);
	  rd.forward(request, response);
	}

}
