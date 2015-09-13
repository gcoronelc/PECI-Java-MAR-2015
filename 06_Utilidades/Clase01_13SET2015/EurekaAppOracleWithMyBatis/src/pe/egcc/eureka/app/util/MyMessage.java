package pe.egcc.eureka.app.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public final class MyMessage {

  private MyMessage() {
  }

  public static void showInfo(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA - INFO", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void showError(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA - ERROR", JOptionPane.ERROR_MESSAGE);
  }

}
