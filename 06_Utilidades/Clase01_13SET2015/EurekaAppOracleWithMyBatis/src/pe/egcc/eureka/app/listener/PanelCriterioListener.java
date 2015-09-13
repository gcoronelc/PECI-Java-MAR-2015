package pe.egcc.eureka.app.listener;

import java.util.EventListener;
import java.util.List;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public interface PanelCriterioListener extends EventListener {

  public void onNuevaConsulta(List lista);

  public void onExportarExcel();

  public void onExportarCSV();
  
  public void onExportarPDF();

  public void onNuevo();

  public void onEditar();

  public void onEliminar();

  public void onSalir();

}
