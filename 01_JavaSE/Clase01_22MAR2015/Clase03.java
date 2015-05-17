class Clase03{

  public static void main(String[] args){
	if( args.length == 0)
	  System.out.println("Hola todos.");
    else {
	  String nombres = "";
	  for(int i = 0; i < args.length; i++ )
		nombres = nombres + args[i] + " ";
      System.out.println("Hola amigo(s): " + nombres);
	}
  }
	
}