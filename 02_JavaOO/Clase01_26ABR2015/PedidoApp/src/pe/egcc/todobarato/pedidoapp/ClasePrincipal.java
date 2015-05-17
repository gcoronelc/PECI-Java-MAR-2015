package pe.egcc.todobarato.pedidoapp;

import javax.swing.UIManager;
import pe.egcc.todobarato.pedidoapp.view.PedidoView;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class ClasePrincipal {

  public static void main(String[] args) {
    //PedidoView.main(null);
    try {
//      UIManager.setLookAndFeel(
//            UIManager.getCrossPlatformLookAndFeelClassName());
      UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
    }
    
    new PedidoView().setVisible(true);
  }
  
}
