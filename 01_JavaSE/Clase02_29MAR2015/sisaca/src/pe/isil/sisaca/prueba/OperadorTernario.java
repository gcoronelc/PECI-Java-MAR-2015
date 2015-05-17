package pe.isil.sisaca.prueba;

/**
 *
 * @author Profesor
 */
public class OperadorTernario {

  public static void main(String[] args) {
    int a = 21;
    String es = (a%2==0)?"Es par":"Es impar";
    System.out.println("Es? " + es);
    
    int nota = 10;
    String cond = (nota<0 || nota>20)?"Fuera de rango":(nota>=14?"Aprobado":"Desaprobado");
    System.out.println("condición: " + cond);
    
  }
}
