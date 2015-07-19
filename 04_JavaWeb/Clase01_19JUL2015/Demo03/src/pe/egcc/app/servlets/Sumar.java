package pe.egcc.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Sumar", "/Adicion", "/Panchito" })
public class Sumar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String path = request.getServletPath();
	  if(path.equals("/Sumar")){
	    doSumar(request, response);
	  } else if(path.equals("/Panchito")){
	    doPanchito(request,response);
	  }
	}

	
	private void doPanchito(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
	  // Reporte
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write("<p>Hola Panchito; cómo estas?</p>");
    out.flush();
    out.close();
  }


  private void doSumar(HttpServletRequest request,
	    HttpServletResponse response) throws IOException{
	   // Datos
    int n1 = Integer.parseInt(request.getParameter("n1"));
    int n2 = Integer.parseInt(request.getParameter("n2"));
    // Proceso
    int suma = n1 + n2;
    // Reporte
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write("<p>Número 1: " + n1 + "</p>");
    out.write("<p>Número 2: " + n2 + "</p>");
    out.write("<p>Suma: " + suma + "</p>");
    out.flush();
    out.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  
	  // Reporte
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write("<p>JE Je jE, como se entiende esto?</p>");
    out.flush();
    out.close();
    
	}
}
