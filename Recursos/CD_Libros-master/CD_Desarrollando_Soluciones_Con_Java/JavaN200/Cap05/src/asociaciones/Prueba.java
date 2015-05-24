package asociaciones;

import java.util.Iterator;

public class Prueba {

	
	public static void main(String[] args) {
		
		// Creamos la lista
		Articles lista = new Articles();
		Iterator it;
		Article art;
		
		// Le agregamos elementos
		lista.add( new Article(10,"Impresora",150.0) );
		lista.add( new Article(20,"Monitor  ",320.0) );
		lista.add( new Article(30,"Teclado  ",25.0) );
		
		// Listar la lista de elementos
		it = lista.getList().iterator();
		while( it.hasNext() ){
			art = (Article) it.next();
			System.out.println(art.getCode() + "\t" +
				art.getName() + "\t" + art.getPrice());
		}
		
	}
	
} // Prueba