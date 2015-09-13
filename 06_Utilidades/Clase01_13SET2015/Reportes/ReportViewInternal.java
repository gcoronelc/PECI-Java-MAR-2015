/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JComponent;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Gustavo Coronel
 */
public class ReportViewInternal extends javax.swing.JInternalFrame {

    private JComponent oldBar = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension oldDim = null;
    private String originalTitleFromFrame = "";

    public ReportViewInternal() {
        super("Report Viewer", true, true, true, true);
        setBounds(10, 10, 600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public ReportViewInternal(String titulo) {
        super(titulo, true, true, true, true);
        setBounds(10, 10, 600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void setReporte(JasperPrint print) {
        JRViewer viewer = new JRViewer(print);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(viewer);
    }

    /**
     * Esconde a barra de titulo
     */
    public void removeTitlBar() {
        oldBar = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        oldDim = oldBar.getPreferredSize();
        oldBar.setSize(0, 0);
        oldBar.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    /**
     * Mostra a barra de titulo do internalFrame
     */
    public void restoreTitleBar() {
        oldBar.setPreferredSize(oldDim);
        repaint();
    }
}
