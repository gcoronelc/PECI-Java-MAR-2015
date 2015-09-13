package pe.jaa.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.jaa.app.model.PagoBean;
import pe.jaa.app.service.PagoService;

@WebServlet("/PagoController")
public class PagoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int horasTrabajadas = Integer.parseInt(request.getParameter("horasTrabajadas"));
		int diasTrabajados = Integer.parseInt(request.getParameter("diasTrabajados"));
		double pagoPorHora = Double.parseDouble(request.getParameter("pagoPorHora"));
		
		PagoBean pagoBean = new PagoBean();
		pagoBean.setHorasTrabajadas(horasTrabajadas);
		pagoBean.setDiasTrabajados(diasTrabajados);
		pagoBean.setPagoPorHora(pagoPorHora);
		
		PagoService pagoService = new PagoService();
		pagoService.procesar(pagoBean);
		
		request.setAttribute("pagoBean", pagoBean);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
