package egcc.prueba;

import egcc.to.Producto;
import java.util.HashMap;
import java.util.Iterator;

public class Prueba05 {

	public static void main(String[] args) {
		
		// Creación de la lista
		HashMap lista = new HashMap();
		
		// Creación de los productos
		Producto prod01 = new Producto( "Televisor", 650.0 );
		Producto prod02 = new Producto( "Impresora", 187.0 );
		Producto prod03 = new Producto( "Computadora", 2356.0 );
		Producto prod04 = new Producto( "Lavadora", 1348.0 );
		Producto prod05 = new Producto( "Cocina", 582.0 );
		
		// Agregar productos a la lista
		lista.put("01", prod01);
		lista.put("02", prod02);
		lista.put("03", prod03);
		lista.put("04", prod04);
		lista.put("05", prod05);
		
		// Mostrar tamaño de la lista
		System.out.println("Tamaño: " + lista.size());
		
		// Mostrar lista
		Iterator it = lista.keySet().iterator();
		while( it.hasNext() ){
			String key = it.next().toString();
			Producto producto = (Producto)lista.get(key);
			System.out.println(key + " : " + producto.toString());
		}		
				
	} // main
	
} // Prueba05