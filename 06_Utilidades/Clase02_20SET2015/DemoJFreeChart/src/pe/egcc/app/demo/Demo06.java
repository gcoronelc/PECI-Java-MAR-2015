package pe.egcc.app.demo;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Demo06 {

  public static void main(String[] args) {
    //datos del gráfico
    
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    String taxi1 = "Taxi 1";
    String taxi2 = "Taxi 2";

    String dia1 = "Día 1";
    String dia2 = "Día 2";
    String dia3 = "Día 3";
    String dia4 = "Día 4";

    dataset.addValue(18, taxi1, dia1);
    dataset.addValue(15, taxi1, dia2);
    dataset.addValue(16, taxi1, dia3);
    dataset.addValue(12, taxi1, dia4);

    dataset.addValue(16, taxi2, dia1);
    dataset.addValue(19, taxi2, dia2);
    dataset.addValue(10, taxi2, dia3);
    dataset.addValue(11, taxi2, dia4);

    JFreeChart graficoBarras = ChartFactory.createBarChart(
            "Uso de los Taxis", //Título de la gráfica
            "Días de labor", //leyenda Eje horizontal
            "Número de carreras", //leyenda Eje vertical
            dataset, //datos
            PlotOrientation.VERTICAL, //orientación
            true, //incluir leyendas
            true, //mostrar tooltips
            true);

    graficoBarras.setBackgroundPaint(Color.LIGHT_GRAY);

    CategoryPlot plot = (CategoryPlot) graficoBarras.getPlot();
    plot.setBackgroundPaint(Color.CYAN); //fondo del grafico
    plot.setDomainGridlinesVisible(true);//lineas de rangos, visibles
    plot.setRangeGridlinePaint(Color.BLACK);//color de las lineas de rangos

    // Mostrando el gráfico
    ChartFrame frame = new ChartFrame("Gráfico de barras", graficoBarras);
    frame.pack();
    frame.setVisible(true);
  }
}
