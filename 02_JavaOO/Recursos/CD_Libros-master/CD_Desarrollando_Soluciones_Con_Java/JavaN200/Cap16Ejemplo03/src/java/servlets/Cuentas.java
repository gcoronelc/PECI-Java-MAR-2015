/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Coronel
 */
public class Cuentas extends HttpServlet {

	private Connection cn = null;
	ArrayList<String> listaErrores = new ArrayList<String>();

	private void crearConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.cn = DriverManager.getConnection("jdbc:mysql://localhost/eurekabank", "root", "");
		} catch (Exception e) {
			this.listaErrores.add("Error en la conexión con la base de datos");
			this.listaErrores.add(e.getMessage());
		}
	}

	@Override
	public void init() throws ServletException {
		super.init();
		this.crearConexion();
	}

	@Override
	public void destroy() {
		super.destroy();
		try {
			if (this.cn != null) {
				this.cn.close();
			}
		} catch (Exception e) {
			this.cn = null;
		}
	}

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
		boolean hayError = false;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sucursal = null;
		String sql = "select * from cuenta where chr_sucucodigo = ?";
		String datos = "";
		// Dato
		sucursal = request.getParameter("codigo");
		// Proceso
		try {
			pst = this.cn.prepareStatement(sql);
			pst.setString(1, sucursal);
			rs = pst.executeQuery();
			while (rs.next()) {
				String cuenta = rs.getString("chr_cuencodigo");
				String cliente = rs.getString("chr_cliecodigo");
				Double saldo = rs.getDouble("dec_cuensaldo");
				datos += "<tr>";
				datos += "<td>" + cuenta + "</td>";
				datos += "<td>" + cliente + "</td>";
				datos += "<td>" + saldo + "</td>";
				datos += "</tr>";
			}
		} catch (Exception e) {
			hayError = true;
			this.listaErrores.add("Error en el proceso");
			this.listaErrores.add(e.getMessage());
		}
		if (datos.length() == 0) {
			datos = "<p>No hay cuentas para la sucursal " + sucursal + "</p>";
		} else {
			datos = "<table border='1' width='200'>" +
					"<tr>" +
					"<td>Cuenta</td>" +
					"<td>Cliente</td>" +
					"<td>Saldo</td>" +
					"</tr>" +
					datos +
					"</table>";
		}
		// Reporte
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Consulta de cuentas</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>EurekaBank</h1>");
		if (hayError) {
			String errores = "";
			for (String error : listaErrores) {
				errores += error + "<br>";
			}
			out.println("<p>ERRORES</p>");
			out.println("<p>" + errores + "<p>");
		} else {
			out.println(datos);
		}
		out.println("<a href='sucursal.html'>Otra Consulta</a>");
		out.println("</body>");
		out.println("</html>");
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
	@Override
	public String getServletInfo() {
		return "Consulta de Cuentas.";
	}// </editor-fold>
}
