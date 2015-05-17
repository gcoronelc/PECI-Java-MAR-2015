package pe.egcc.app.prueba;

import pe.egcc.app.domain.Estudiante;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba07 {

  public static void main(String[] args) {
    Estudiante[] lista = new Estudiante[10];

    lista[0] = new Estudiante(501, "Juan Perez", 18);
    lista[1] = new Estudiante(502, "Juan Perez", 15);
    lista[2] = new Estudiante(503, "Juan Perez", 10);
    lista[3] = new Estudiante(504, "Juan Perez", 9);
    lista[4] = new Estudiante(505, "Juan Perez", 7);
    lista[5] = new Estudiante(506, "Juan Perez", 14);
    lista[6] = new Estudiante(507, "Juan Perez", 20);
    lista[7] = new Estudiante(508, "Juan Perez", 19);
    lista[8] = new Estudiante(509, "Juan Perez", 11);
    lista[9] = new Estudiante(510, "Juan Perez", 13);
    
    for (Estudiante o : lista) {
      System.out.println(o.getCodigo() + " - " +
        o.getNombre() + " - " + o.getNota());
    }
  }
}
