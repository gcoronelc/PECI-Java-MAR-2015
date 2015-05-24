package egcc.pruebas;

import egcc.model.Calculadora1;

public class Prueba02 {

	public static void main(String[] args) {

		// Datos
		int n1 = 5;
		int n2 = 8;

		// Proceso
		Calculadora1 obj = new Calculadora1();
		int suma = obj.suma(n1, n2);
		int f1 = obj.factorial(n1);
		int f2 = obj.factorial(n2);

		// Reporte
		System.out.println("La suma es: " + suma);
		System.out.println("Factorial de " + n1 + " es: " + f1);
		System.out.println("Factorial de " + n2 + " es: " + f2);

	}
	
} // Prueba02