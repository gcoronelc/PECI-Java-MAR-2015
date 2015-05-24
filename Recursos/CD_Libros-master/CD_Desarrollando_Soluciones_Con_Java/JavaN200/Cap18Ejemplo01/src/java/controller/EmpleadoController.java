package controller;

import dao.to.EmpleadoTO;
import dao.to.SucursalTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EmpleadoModel;
import model.SucursalModel;

/**
 *
 * @author Gustavo Coronel
 */
public class EmpleadoController extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String destino = "/view/main.jsp";
		try {
			String usuario = request.getParameter("usuario");
			String clave = request.getParameter("clave");
			EmpleadoModel empleadoModel = new EmpleadoModel();
			boolean rpta = empleadoModel.verificarUsuario(usuario, clave);
			if (rpta) {
				EmpleadoTO empleadoTO = empleadoModel.consultarPorUsuario(usuario);
				SucursalModel sucursalModel = new SucursalModel();
				SucursalTO sucursalTO = sucursalModel.consultarPorEmpleado(empleadoTO.getCodigo());
				session.setAttribute("empleadoTO", empleadoTO);
				session.setAttribute("sucursalTO", sucursalTO);
			}else{
				request.setAttribute("mensaje", "Datos no son correctos.");
				destino = "/view/login.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			destino = "/view/login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(destino);
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
