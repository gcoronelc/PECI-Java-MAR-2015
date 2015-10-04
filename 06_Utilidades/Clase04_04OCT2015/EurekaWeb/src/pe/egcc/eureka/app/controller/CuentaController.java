package pe.egcc.eureka.app.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pe.egcc.eureka.app.model.EmpleadoBean;
import pe.egcc.eureka.app.service.CuentaService;

@WebServlet({ "/ProcCuentaDeposito", "/ProcCuentaRetiro", 
  "/ProcCuentaTrans", "/ConCuentaMovimientos"})
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String path = request.getServletPath();
	  if(path.equals("/ProcCuentaRetiro")){
	    procCuentaRetiro(request,response);
	  } else if(path.equals("/ConCuentaMovimientos")){
	    conCuentaMovimientos(request,response);
    }
	}

  private void conCuentaMovimientos(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    response.setCharacterEncoding("utf-8");
    response.setContentType("application/json");
    //response.setContentType("text/plain");
    Writer out = response.getWriter();
    String jsonData = "";
    try {
      // Parámetro
      String cuenta = request.getParameter("cuenta");
      // Proceso
      CuentaService cuentaService = new CuentaService();
      List<Map<String,Object>> lista;
      lista = cuentaService.getMovimientos(cuenta);
      Gson gson = new Gson();
      jsonData = gson.toJson(lista);
    } catch (Exception e) {
      e.printStackTrace();
    }
    // Envio de la respuesta
    out.write(jsonData);
    out.flush();
  }

  private void procCuentaRetiro(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    String rpta = "";
    try {
      // Datos
      String cuenta = request.getParameter("cuenta");
      double importe = Double.parseDouble(request.getParameter("importe"));
      String clave = request.getParameter("clave");
      // Empleado
      HttpSession session = request.getSession();
      EmpleadoBean empleadoBean = (EmpleadoBean) session.getAttribute("usuario");
      // Proceso
      CuentaService cuentaService = new CuentaService();
      cuentaService.registrarRetiro(cuenta, importe, 
          empleadoBean.getCodigo(), clave);
      rpta = "1";
    } catch (Exception e) {
      rpta = "0";
    }
    // Envio de la respuesta
    response.setContentType("text/plain");
    response.getWriter().write(rpta);
    response.getWriter().flush();
  }

}
