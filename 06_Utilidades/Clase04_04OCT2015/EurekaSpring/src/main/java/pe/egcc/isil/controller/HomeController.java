package pe.egcc.isil.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.egcc.isil.model.ClienteBean;
import pe.egcc.isil.model.EmpleadoBean;
import pe.egcc.isil.service.ClienteService;
import pe.egcc.isil.service.CuentaService;
import pe.egcc.isil.service.LogonService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LogonService logonService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CuentaService cuentaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Cargando la página de inicio.");
		return "home";
	}
	
	@RequestMapping(value="loadPage.htm")
	public String loadPage(@RequestParam("page") String page){
	  return page;
	}
	
	@RequestMapping(value="ingresoSistema.gustavo", method=RequestMethod.POST,
	    produces="application/text")
	@ResponseBody
	public String ingresoSistema(
	    @RequestParam("usuario") String usuario,
	    @RequestParam("clave") String clave,
	    HttpSession session){
	  String texto;
	  EmpleadoBean empleadoBean;
	  empleadoBean = logonService.validar(usuario, clave);
	  if(empleadoBean == null){
	    texto = "0";
	  } else {
	    session.setAttribute("usuario", empleadoBean);
	    texto = "1";
	  }
	  return texto;
	}
	
	@RequestMapping(value="clienteconsultar.htm", method=RequestMethod.POST)
	public String clienteConsultar(
	    @ModelAttribute ClienteBean clienteBean,
	    Model model){
	  model.addAttribute("lista", clienteService.getClientes(clienteBean));
	  return "conclientes2";
	}
	
	@RequestMapping(value="cuentaMovimientos.htm", method=RequestMethod.POST,
	    produces="application/json")
	@ResponseBody
	public List<Map<String,Object>> cuentaMovimientos(
	    @RequestParam("cuenta") String cuenta){
	  List<Map<String,Object>> lista = cuentaService.getMovimientos(cuenta);
	  return lista;
	}
	
}
