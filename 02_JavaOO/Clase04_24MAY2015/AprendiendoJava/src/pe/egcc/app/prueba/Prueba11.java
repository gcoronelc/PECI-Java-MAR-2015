package pe.egcc.app.prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba11 {

  public static void main(String[] args) {
    JFrame jFrame = new JFrame();
    
    jFrame.setSize(400, 400);
    
    JButton jButton = new JButton("Saludar");
    
    jButton.addActionListener
        ( e -> JOptionPane.showMessageDialog(null, "Hola a todos."));
    
    jFrame.add(jButton);
    
    jFrame.setVisible(true);
  }
  
}
