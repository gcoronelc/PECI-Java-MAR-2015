package egcc.prueba;

import egcc.to.Producto;
import java.util.HashSet;
import java.util.Iterator;

public class Prueba02 {

	public static void main(String[] args) {
		
		// Creación de la lista
		HashSet<Producto> lista = new HashSet<Producto>();
		
		// Creación de los productos
		Producto prod01 = new Producto( "Televisor", 650.0 );
		Producto prod02 = new Producto( "Impresora", 187.0 );
		Producto prod03 = new Producto( "Computadora", 2356.0 );
		Producto prod04 = new Producto( "Lavadora", 1348.0 );
		Producto prod05 = new Producto( "Cocina", 582.0 );
		Producto prod06 = new Producto( "Cocina", 582.0 );
		
		// Agregar productos a la lista
		lista.add(prod01);
		lista.add(prod02);
		lista.add(prod03);
		lista.add(prod04);
		lista.add(prod05);
		lista.add(prod06);
		
		// Mostrar tamaño de la lista
		System.out.println("Tamaño: " + lista.size());
		
		// Mostrar elementos de la lista
		Iterator<Producto> it = lista.iterator();
		while( it.hasNext() ){
			System.out.println(it.next().toString());
		}
		
	} // main
	
} // Prueba02