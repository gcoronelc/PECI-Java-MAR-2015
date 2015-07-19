package pe.egcc.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.services.MateService;

@WebServlet("/MateServlets")
public class MateServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // Datos
	  int n1 = Integer.parseInt(request.getParameter("n1"));
	  int n2 = Integer.parseInt(request.getParameter("n2"));
	  String operador = request.getParameter("operador");
	  // Proceso
	  MateService mateService = new MateService();
	  int rpta = mateService.calcular(n1, n2, operador);
	  // Reporte
	  response.setContentType("text/html");
	  PrintWriter out = response.getWriter();
	  out.print("<p>Número 1: " + n1 + "</p>");
	  out.print("<p>Número 2: " + n2 + "</p>");
	  out.print("<p>Operación: " + operador + "</p>");
	  out.print("<p>Respuesta: " + rpta + "</p>");
	  out.flush();
	  out.close();
	}

}
