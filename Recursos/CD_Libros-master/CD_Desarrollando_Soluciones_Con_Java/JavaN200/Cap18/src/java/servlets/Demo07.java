/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.DAOFactory;
import dao.design.IEmpleadoDAO;
import dao.to.EmpleadoTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gustavo
 */
public class Demo07 extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String paterno = request.getParameter("paterno");
			IEmpleadoDAO empleadoDAO = DAOFactory.getInstance().getEmpleadoDAO();
			ArrayList<EmpleadoTO> lista = empleadoDAO.consultarPorPaterno(paterno);
			request.setAttribute("lista", lista);
			request.setAttribute("mensaje", "Proceso OK.");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("demo07.jsp");
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
