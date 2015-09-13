package pe.egcc.app.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import pe.egcc.app.service.VentasService;

@WebListener
public class AppListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent event) {
		VentasService ventasService = new VentasService();
		event.getSession().setAttribute("ventasService", ventasService);
		event.getSession().setAttribute("inicio", "Hola amigos.");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
	}

}
