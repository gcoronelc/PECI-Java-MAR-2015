package pe.isil.sisaca.prueba;

/**
 *
 * @author Profesor
 */
public class OperadoresComparacion {

  public static void main(String[] args) {
    
    int a = 10;
    int b = 15;
    
    boolean mayor = (a>b);
    boolean mayorIgual = (a>=b);
    boolean menor = (a<b);
    boolean menorIgual = (a<=b);
    boolean igual = (a==b);
    boolean diferente = (a!=b);
    
    System.out.println("Mayor = " + mayor);
    System.out.println("Mayor Igual = " + mayorIgual);
    System.out.println("Menor = " + menor);
    System.out.println("Manor Igual = " + menorIgual);
    System.out.println("Igual = " + igual);
    System.out.println("Diferente = " + diferente);
  }
}
