package pe.isil.sisaca.model;

/**
 *
 * @author Profesor
 */
public class MateModel {
  
  public String autor = "YO";
  
  /*
   * Tener en cuenta que el promedio se debe
   * calcular si no tiene cuotas pendientes.
  */
  /**
   * Método para encontrar el promedio de 3 notas.
   * Las notas deben estar en el rango de 0 a 20.
   * @param n1 Nota de practicas
   * @param n2 Examen parcial
   * @param n3 Examen final
   * @return 
   */
  public int promedio(int n1, int n2, int n3){
    return (n1 + n2 + n3) / 3;
  }
}
