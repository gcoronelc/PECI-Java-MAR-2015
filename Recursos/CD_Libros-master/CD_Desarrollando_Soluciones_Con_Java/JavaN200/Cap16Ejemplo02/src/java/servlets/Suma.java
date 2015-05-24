/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Coronel
 */
public class Suma extends HttpServlet {
	// Estados
	enum Estados {

		FORMULARIO, RESPUESTA, ERROR
	};

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// Proceso General
		Estados estado = Estados.FORMULARIO;
		int n1 = 0;
		int n2 = 0;
		int suma = 0;
		String msgError = "";
		try {
			if (request.getParameterMap().size() > 0) {
				estado = Estados.RESPUESTA;
				// Datos
				n1 = Integer.parseInt(request.getParameter("num1"));
				n2 = Integer.parseInt(request.getParameter("num2"));
				// Proceso
				suma = n1 + n2;
			}
		} catch (Exception e) {
			estado = Estados.ERROR;
			msgError = e.getMessage();
		}
		// Reporte al usuario
		out.println("<html>");
		out.println("<head><title>Cap16Ejemplo02</title></head>");
		out.println("<body>");
		out.println("<h1>Suma de Dos N&uacute;meros</h1>");
		if (estado == Estados.FORMULARIO) {
			out.println("<form action='Suma' method='post'>");
			out.println("<table width='256'>");
			out.println("<tr>");
			out.println("<td width='85'>Número 1</td>");
			out.println("<td width='58'>");
			out.println("<input type='text' name='num1' maxlength='5' size='8' id='num1'/>");
			out.println("</td>");
			out.println("<td width='85'>&nbsp;</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Número 2</td>");
			out.println("<td>");
			out.println("<input type='text' name='num2' maxlength='5' size='8' id='num2'/>");
			out.println("</td>");
			out.println("<td>");
			out.println("<input name='procesar' type='submit' id='procesar' value='Procesar'/>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
		} else if (estado == Estados.RESPUESTA) {
			out.println("<p>Numero 1 = " + n1 + "</p>");
			out.println("<p>Numero 2 = " + n2 + "</p>");
			out.println("<p>Suma = " + suma + "</p>");
			out.println("<A HREF='Suma'>Otra Suma</A>");
		} else {
			out.println("<h3>Error</h3>");
			out.println("<p>Dotos no son correctos.</p>");
			out.println("<p>Mensaje: " + msgError + "</p>");
			out.println("<A HREF='Suma'>Otra Suma</A>");	
		}
		out.println("</body></html>");
		out.close();
	}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/** 
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/** 
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/** 
	 * Returns a short description of the servlet.
	 */
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
