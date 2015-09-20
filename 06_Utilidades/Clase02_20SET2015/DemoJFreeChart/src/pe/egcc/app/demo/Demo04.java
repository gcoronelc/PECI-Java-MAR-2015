package pe.egcc.app.demo;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Demo04 {

  public static void main(String[] args) {
    // Definiendo la fuente de datos
    DefaultPieDataset data = new DefaultPieDataset();
    data.setValue("Artículo 1", 40.55);
    data.setValue("Artículo 2", 81.23);
    data.setValue("Artículo 3", 61.54);

    // Creando el gráfico
    JFreeChart chart = ChartFactory.createPieChart(
            "Ejemplo de Gráfico Tipo Pastel", // Título del gráfico
            data, // DataSet
            true, // Leyenda
            true, // ToolTips
            true);

    // Mostrar el gráfico en un archivo PDF
    try {
      Document doc = new Document();
      PdfWriter.getInstance(doc, new FileOutputStream("C:\\EGCC\\doc.pdf"));
      doc.open();
      BufferedImage bufferedImage = chart.createBufferedImage(500, 300);
      Image image = Image.getInstance(bufferedImage, null);
      doc.add(image);
      doc.close();
      JOptionPane.showMessageDialog(null, "Ok.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
