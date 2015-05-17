package egcc.prueba;

import egcc.to.Producto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Prueba04 {

	public static void main(String[] args) {
		
		// Creación de la lista
		ArrayList lista = new ArrayList();
		
		// Creación de los productos
		Producto prod01 = new Producto( "Televisor", 650.0 );
		Producto prod02 = new Producto( "Impresora", 187.0 );
		Producto prod03 = new Producto( "Computadora", 2356.0 );
		Producto prod04 = new Producto( "Lavadora", 1348.0 );
		Producto prod05 = new Producto( "Cocina", 582.0 );
		
		// Agregar productos a la lista
		lista.add(prod01);
		lista.add(prod02);
		lista.add(prod03);
		lista.add(prod04);
		lista.add(prod05);
		
		// Ordenar lista
		Collections.sort(lista);
		
		// Mostrar tamaño de la lista
		System.out.println("Tamaño: " + lista.size());
		
		// Mostrar lista
		Iterator it = lista.iterator();
		while( it.hasNext() ){
			System.out.println(it.next().toString());
		}		
		
		// Buscar en la lista
		Producto dato = new Producto("impresora", 0);
		int posicion = Collections.binarySearch(lista, dato);
		System.out.println("Posicion = " + posicion);
		
	} // main
	
} // Prueba04