package pe.egcc.eureka.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pe.egcc.eureka.model.EmpleadoBean;
import pe.egcc.eureka.service.CuentaService;

@WebServlet({"/CuentaRetiro","/CuentaDeposito"})
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, 
	    HttpServletResponse response) throws ServletException, IOException {
	  
	  String path = request.getServletPath();
	  if(path.equals("/CuentaRetiro")){
	    cuentaRetiro(request,response);
	  }
	  
	  
	}


  private void cuentaRetiro(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    Map<String, Object> rpta = new HashMap<String, Object>();
    try {
      // Parametros
      String cuenta = request.getParameter("cuenta");
      double importe = Double.parseDouble(request.getParameter("importe"));
      String clave = request.getParameter("clave");
      // Empleado
      HttpSession session = request.getSession();
      EmpleadoBean bean = (EmpleadoBean) session.getAttribute("usuario");
      // Proceso
      CuentaService service = new CuentaService();
      service.registrarRetiro(cuenta, importe, bean.getCodigo(), clave);
      rpta.put("cod", 1);
    } catch (Exception e) {
      rpta.put("cod", -1);
      rpta.put("error", e.getMessage());
    }
    // Json
    Gson gson = new Gson();
    String dataJson = gson.toJson(rpta);
    // Retorno
    response.setContentType("Application/json; charset=UTF-8");
    response.getWriter().write(dataJson);
    response.getWriter().flush();
    response.getWriter().close();
  }

}
