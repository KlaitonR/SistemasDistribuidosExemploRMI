package RMI;

import java.rmi.Naming;

public class ClientePrisioneiro {
	
	public static void main(String[] args){
	    
	    try{
	    	
	    	Veredito v = (Veredito) Naming.lookup("rmi://COLOCAR IP AQUI:1099/JuizService"); //COLOCAR IP AQUI
	    	System.out.println(v.veredito(true, false));
	    	
	    
	    } catch (Exception e) {
	      System.err.println("Exceção no cliente" + e.toString());
	      e.printStackTrace();
	    }
	  }

}
