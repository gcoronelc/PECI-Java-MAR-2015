// Ejercicio 01
class Armijos01{
	public static void main(String[]args){
		Double precio = Double.parseDouble(args[0]);
		int cant = Integer.parseInt(args[1]);
		Double total = 0.00;
		Double subTotal = 0.00;
		Double impuesto = 0.00;
		
		total = precio * cant;
		impuesto = total * 0.17;
		subTotal = total - impuesto;
		
		System.out.println("Precio  :" + precio);
		System.out.println("Cantidad:" + cant);
		System.out.println("SubTotal" + subTotal);
		System.out.println("Impuesto" + impuesto);
		System.out.println("Total" + total);
	}
}