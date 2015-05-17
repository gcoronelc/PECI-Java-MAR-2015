
package ACHING.app;

/** Ejercicio1
==========

Desarrollar un programa para
calcular el impuesto y total
de una venta.

Los datos de entrada son:
-Precio del producto
-La cantidad vendida**/

class Ejercicio1{
	
	public static void main(String[] args){
		// Datos
		double p = Double.parseDouble(args[0]);
		int c = Integer.parseInt(args[1]);
		// Proceso
		double cv = (p*c);
		double i = (cv*0.18);
		double vt = p*c + i;
		// Reporte
		System.out.println("Precio = "+p);
		System.out.println("Cantidad = "+c);
		System.out.println("Sub Total = "+cv);
		System.out.println("Impuesto = "+i);
		System.out.println("Venta Total = "+vt);
	}
	
}

