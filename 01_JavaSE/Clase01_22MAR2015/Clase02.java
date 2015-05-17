class Clase02{

  public static void main(String[] args){
	if( args.length == 0)
	  System.out.println("Hola todos.");
    else if (args.length == 1)
      System.out.println("Hola " + args[0]);
    else 
	  System.err.println("ERROR: muchos nombres.");
  }
	
}