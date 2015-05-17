package controller;

import dao.to.EmpleadoTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CuentaModel;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaController extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op.equals("01")) {
			proceso_deposito(request, response);
		} else if (op.equals("02")) {
			proceso_retiro(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/view/main.jsp");
			rd.forward(request, response);
		}
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

	private void proceso_deposito(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {
			// Datos
			String cuenta = request.getParameter("cuenta");
			Double importe = Double.parseDouble(request.getParameter("importe"));
			HttpSession session = request.getSession(true);
			EmpleadoTO empleadoTO = (EmpleadoTO) session.getAttribute("empleadoTO");
			String empleado = empleadoTO.getCodigo();
			// Proceso
			CuentaModel cuentaModel = new CuentaModel();
			cuentaModel.deposito(cuenta, importe, empleado);
			request.setAttribute("mensaje", "Proceso Ok.");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/deposito.jsp");
		rd.forward(request, response);
	}

	private void proceso_retiro(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {
			// Datos
			String cuenta = request.getParameter("cuenta");
			Double importe = Double.parseDouble(request.getParameter("importe"));
			String clave = request.getParameter("clave");
			HttpSession session = request.getSession(true);
			EmpleadoTO empleadoTO = (EmpleadoTO) session.getAttribute("empleadoTO");
			String empleado = empleadoTO.getCodigo();
			// Proceso
			CuentaModel cuentaModel = new CuentaModel();
			cuentaModel.retiro(cuenta, clave, importe, empleado);
			request.setAttribute("mensaje", "Proceso Ok.");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/retiro.jsp");
		rd.forward(request, response);
	}
}
