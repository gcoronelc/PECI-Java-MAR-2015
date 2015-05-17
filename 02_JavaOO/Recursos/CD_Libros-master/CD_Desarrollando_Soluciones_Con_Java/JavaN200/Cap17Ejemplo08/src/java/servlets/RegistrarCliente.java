/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.DAOFactory;
import dao.design.IClienteDAO;
import dao.to.ClienteTO;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Coronel
 */
public class RegistrarCliente extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ArrayList<String> mensajes = new ArrayList<String>();
		try {
			// Datos
			String paterno = request.getParameter("paterno");
			String materno = request.getParameter("materno");
			String nombre = request.getParameter("nombre");
			String dni = request.getParameter("dni");
			String ciudad = request.getParameter("ciudad");
			String direccion = request.getParameter("direccion");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("email");
			// Proceso
			ClienteTO clienteTO = new ClienteTO();
			clienteTO.setPaterno(paterno);
			clienteTO.setMaterno(materno);
			clienteTO.setNombre(nombre);
			clienteTO.setDni(dni);
			clienteTO.setCiudad(ciudad);
			clienteTO.setDireccion(direccion);
			clienteTO.setTelefono(telefono);
			clienteTO.setEmail(email);
			IClienteDAO clienteDAO = DAOFactory.getInstance().getClienteDAO();
			clienteDAO.insertar(clienteTO);
			mensajes.add("Proceso ejecutado correctamente.");
			mensajes.add(MessageFormat.format("Código asignado: {0}.", clienteTO.getCodigo()));
		} catch (Exception e) { // Error
			mensajes.add("Error en el proceso.");
			mensajes.add("Error: " + e.getMessage());
		}
		// Salida
		request.setAttribute("mensajes", mensajes);
		RequestDispatcher rd = request.getRequestDispatcher("registrarCliente.jsp");
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
