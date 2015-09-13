package pe.egcc.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.app.model.VentaBean;
import pe.egcc.app.service.VentasService;

@WebServlet({ "/RegistrarVenta", "/Resumen" })
public class VentaController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    String servletPath = request.getServletPath();
    if(servletPath.equals("/RegistrarVenta")){
      registrarVenta(request,response);
    } else if(servletPath.equals("/Resumen")){
      resumen(request,response);
    }
  }

  private void resumen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Variables
    int cant = 0;
    double precio = 0.0;
    double importe = 0.0;
    // Proceso
    VentasService ventasService;
    ventasService = (VentasService) request.getSession().getAttribute("ventasService");
    
    for(VentaBean bean: ventasService.getLista()){
      cant += bean.getCant();
      precio += bean.getPrecio();
      importe += bean.getImporte();
    }
    
    precio = precio / ventasService.getLista().size();
    
    request.setAttribute("cant", cant);
    request.setAttribute("precio", precio);
    request.setAttribute("importe", importe);
    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("resumen.jsp");
    rd.forward(request, response);
  }

  private void registrarVenta(HttpServletRequest request,
      HttpServletResponse response) 
          throws ServletException, IOException {
    String destino = "";
    try {
      // Datos
      VentaBean ventaBean = new VentaBean();
      ventaBean.setCliente(request.getParameter("cliente"));
      ventaBean.setProducto(request.getParameter("producto"));
      ventaBean.setPrecio(Double.parseDouble(request.getParameter("precio")));
      ventaBean.setCant(Integer.parseInt(request.getParameter("cant")));
      // Proceso
      ventaBean.setImporte(ventaBean.getPrecio() * ventaBean.getCant());
      // Guardar venta en sesion
      HttpSession session = request.getSession();
      VentasService ventasService = (VentasService) session.getAttribute("ventasService");
      ventasService.agregarVenta(ventaBean);
      destino = "mensaje.jsp";
      request.setAttribute("mensaje", "Proceso ok.");
    } catch (Exception e) {
      e.printStackTrace();
      destino = "mensaje.jsp";
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

}
