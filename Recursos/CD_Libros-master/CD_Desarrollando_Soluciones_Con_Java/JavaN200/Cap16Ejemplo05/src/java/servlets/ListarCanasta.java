package servlets;

import canasta.CanastaItem;
import canasta.CanastaList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gustavo
 */
public class ListarCanasta extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		out.println("<h1>Canasta</h1>");
		HttpSession session = request.getSession(true);
		if(session.getAttribute("canasta") == null){
			out.println("<h3>No existe canasta</h3>");
			out.println("<a href='registrarVenta.html'>Regresar</a>");
			out.close();
			return;
		}
		CanastaList canasta = (CanastaList)session.getAttribute("canasta");
		if(canasta.size() == 0){
			out.println("<h3>Canasta vacia</h3>");
			out.println("<a href='registrarVenta.html'>Regresar</a>");
			out.close();
			return;
		}
		out.println("<table border='1'>" +
				"<tr>" +
				"<th>Articulo</th>" +
				"<th>Precio</th>" +
				"<th>Cantidad</th>" +
				"<th>Subtotal</th>" +
				"</tr>");
		Double total = 0.0;
		for (CanastaItem item : canasta.getLista()) {
			total += item.getSubtotal();
			out.println("<tr>" +
				"<td>" + item.getArticulo() + "</td>" +
				"<td>" + item.getPrecio() + "</td>" +
				"<td>" + item.getCantidad() + "</td>" +
				"<td>" + item.getSubtotal() + "</td>" +
				"</tr>");
		}
		out.println("</table>");
		out.println("<h2>Total: " + total + "</h2>");
		out.println("<a href='registrarVenta.html'>Regresar</a>");
		out.println("<a href='NuevaVenta'>Nueva Venta</a>");
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
