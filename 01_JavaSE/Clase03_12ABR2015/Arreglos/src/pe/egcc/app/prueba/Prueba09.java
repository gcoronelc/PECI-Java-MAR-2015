package pe.egcc.app.prueba;

import java.util.Arrays;
import pe.egcc.app.domain.Estudiante;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba09 {

  public static void main(String[] args) {
    Estudiante[] lista = new Estudiante[10];

    lista[0] = new Estudiante(501, "Juan Perez", 18);
    lista[1] = new Estudiante(502, "Carla Tarazona", 15);
    lista[2] = new Estudiante(503, "Pedro Cateriano", 10);
    lista[3] = new Estudiante(504, "Alan Garcia", 9);
    lista[4] = new Estudiante(505, "Magaly Medina", 7);
    lista[5] = new Estudiante(506, "Nadine Heredia", 14);
    lista[6] = new Estudiante(507, "Alejandro Toledo", 20);
    lista[7] = new Estudiante(508, "Keiko Fujimori", 19);
    lista[8] = new Estudiante(509, "Miguel Grau", 11);
    lista[9] = new Estudiante(510, "Santa Rosa", 13);

    // La magia de Java 8
    Arrays.stream(lista)
            .sorted((o1, o2) -> {
              int rpta = 0;
              if (o1.getNota() > o2.getNota()) {
                rpta = -1;
              } else if (o1.getNota() < o2.getNota()) {
                rpta = 1;
              }
              return rpta;
            })
            .filter(o -> o.getNota() >= 14)
            .forEach(o -> System.out.println(o.getCodigo() + " - "
              + o.getNombre() + " - " + o.getNota()));

  }
}
