package pe.egcc.eureka.app.prueba;

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
public class Prueba04 {

  public static void main(String[] args) {
    
    JFrame demo = new JFrame("Demo Listener");
    
    JButton boton = new JButton("Saludo");
    demo.add(boton);
    
    boton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Hola todos.");
      }
    });
    
    
    demo.setVisible(true);
    
    
    
  }
  
}
