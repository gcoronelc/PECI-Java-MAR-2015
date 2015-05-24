package agregacion;

import java.util.GregorianCalendar;
import java.util.Iterator;

public class Prueba {

	public static void main(String[] args) {
		
		// Creación de Objetos
		Banco banco01 = new Banco("Santader", "España");
		Banco banco02 = new Banco("Credito", "Perú");
		Cliente clie01 = new Cliente("Gustavo", "06914897", new GregorianCalendar(1964, 3, 6) );
		Cliente clie02 = new Cliente("Claudia", "10156345", new GregorianCalendar(1970, 6, 15) );
		Cliente clie03 = new Cliente("Sergio", "11548227", new GregorianCalendar(1960, 2, 3) );
		
		// Agregamos los clientes al Banco
		banco01.agregarCliente(clie01);
		banco01.agregarCliente(clie02);
		banco02.agregarCliente(clie01);
		banco02.agregarCliente(clie03);
		
		// Imprimimos los clientes
		System.out.println("Banco: " + banco01.getNombre());
		Iterator it = banco01.getClientes().iterator();
		while( it.hasNext() ){
			Cliente obj = (Cliente) it.next();
			System.out.println(obj.toString());
		}
		System.out.println("Banco: " + banco02.getNombre());
		it = banco02.getClientes().iterator();
		while( it.hasNext() ){
			Cliente obj = (Cliente) it.next();
			System.out.println(obj.toString());
		}
	}
	
} // Prueba