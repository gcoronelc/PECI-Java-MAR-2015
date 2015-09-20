package pe.egcc.app.demo;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Demo05 {

  public static void main(String[] args) {
    
    //datos del gráfico
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    dataset.addValue(20000.00, "SOLES", "INGRESOS");
    dataset.addValue(11567.8, "SOLES", "SALIDA");

    JFreeChart graficoBarras = ChartFactory.createBarChart(
            "RESUMEN DE MOVIMIENTOS", //Título de la gráfica
            "TIPOS DE MOVIMIENTOS", //leyenda Eje horizontal
            "MILES DE SOLES", //leyenda Eje vertical
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
    ChartFrame frame = new ChartFrame("REPORTE GRAFICO", graficoBarras);
    frame.pack();
    frame.setVisible(true);
  }
}
