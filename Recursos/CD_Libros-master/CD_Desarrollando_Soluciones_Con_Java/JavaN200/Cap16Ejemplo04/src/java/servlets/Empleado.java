package servlets;

import business.EmpleadoBusiness;
import dao.to.EmpleadoTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Coronel
 */
public class Empleado extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// Variables
		String sucursal = null;
		ArrayList<EmpleadoTO> lista = null;
		boolean hayError = false;
		String msgError = null;
		EmpleadoBusiness empleadoBusiness = new EmpleadoBusiness();
		// Proceso
		try {
			// Dato
			sucursal = request.getParameter("sucursal");
			lista = empleadoBusiness.consultarPorSucursal(sucursal);
		} catch (Exception e) {
			hayError = true;
			msgError = e.getMessage();
		}
		// Reporte
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Consulta de Empleados</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>EurekaBank</h1>");
		out.println("<h2>Consulta de Empleados</h2>");
		if(hayError){
			out.println("<p>ERROR en el proceso<p>");
			out.println("<p>" + msgError + "</p>");
		}else if(lista.size() == 0){
			out.println("<p>No hay empleados.</p>");
		}else{
			out.println("<table width='400' border='1'>" +
					"<tr>" +
					"<th>Código</th>" +
					"<th>Paterno</th>" +
					"<th>Materno</th>" +
					"<th>Nombre</th>" +
					"</tr>");
			for (EmpleadoTO empleadoTO : lista) {
				out.println("<tr>" +
					"<td>" + empleadoTO.getCodigo() + "</td>" +
					"<td>" + empleadoTO.getPaterno() + "</td>" +
					"<td>" + empleadoTO.getMaterno() + "</td>" +
					"<td>" + empleadoTO.getNombre() + "</td>" +
					"</tr>");
			}
			out.println("</table>");
		}
		out.println("<a href='empleado.html'>Otra Consulta</a>");
		out.println("</body>");
		out.println("</html>");
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
