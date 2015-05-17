

	class Clase06{
	
	public static void main(String[] args){
		//variables
		Double precio=Double.parseDouble(args[0]);
		int cantidad=Integer.parseInt(args[1]);
		//proceso
		Double total=precio+cantidad;
		Double impuesto=total*0.18;
		
		
		System.out.println("el precio ="+precio);
		System.out.println("la cantidad ="+cantidad);
		System.out.println("impuesto ="+impuesto);
		System.out.println("total ="+total);
	}
	
	
	}