package pe.isil.sisaca.prueba;

/**
 *
 * @author Profesor
 */
public class Bucle01 {

  public static void main(String[] args) {
    int n = 1;
    while(n++ <= 10){
      if(n==4) continue;
      System.out.println(n + ".- Alianza Campeón");
      if(n == 8) break;
    }
  }
}
