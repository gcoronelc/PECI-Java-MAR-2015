package pe.egcc.app.service;

import java.util.ArrayList;
import java.util.List;

import pe.egcc.app.model.VentaBean;

public class VentasService {

  private List<VentaBean> lista;
  
  public VentasService() {
    lista = new ArrayList<VentaBean>();
  }

  public void agregarVenta(VentaBean ventaBean){
    lista.add(ventaBean);
  }
  
  public List<VentaBean> getLista(){
    return lista;
  }
}
