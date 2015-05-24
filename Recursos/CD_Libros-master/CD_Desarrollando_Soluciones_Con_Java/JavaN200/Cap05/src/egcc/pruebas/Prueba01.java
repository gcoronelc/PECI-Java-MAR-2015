package egcc.pruebas;

import egcc.model.Ecuacion;

public class Prueba01 {

    public static void main (String[] args) {
		
		// Valores de los coeficientes a, b y c
		Ecuacion obj = new Ecuacion( 1, -4, 3 );
		
		// Se obtienen las dos raíces
		double rpta[] = obj.resolver();
		
		// Se imprime el resultado
		System.out.println("X1 = " + rpta[0]);
		System.out.println("X2 = " + rpta[1]);
		
    } // main

} // Prueba01