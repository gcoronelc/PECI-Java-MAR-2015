package pe.egcc.app.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Demo01 {

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

    // Mostrando el gráfico
    ChartFrame frame = new ChartFrame("JFreeChart", chart);
    frame.pack();
    frame.setVisible(true);
  }
}
