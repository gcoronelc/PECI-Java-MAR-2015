package servlets;

import canasta.CanastaItem;
import canasta.CanastaList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gustavo
 */
public class AgregarItem extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Variables
		HttpSession session = null;
		String articulo = null;
		Double precio = null;
		Integer cantidad = null;
		CanastaList canasta = null;
		CanastaItem item = null;
		// Datos
		try {
			articulo = request.getParameter("articulo");
			precio = Double.parseDouble(request.getParameter("precio"));
			cantidad = Integer.parseInt(request.getParameter("cantidad"));
		} catch (Exception e) {
			response.sendRedirect("paginaError.html");
			return;
		}
		// Proceso
		item = new CanastaItem();
		item.setArticulo(articulo);
		item.setPrecio(precio);
		item.setCantidad(cantidad);
		session = request.getSession(true);
		if (session.getAttribute("canasta") == null) {
			canasta = new CanastaList();
		} else {
			canasta = (CanastaList) session.getAttribute("canasta");
		}
		canasta.addItem(item);
		session.setAttribute("canasta", canasta);
		// Reporte
		RequestDispatcher rd = request.getRequestDispatcher("ListarCanasta");
		rd.forward(request, response);
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
