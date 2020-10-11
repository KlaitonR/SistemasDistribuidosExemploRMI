package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientePrisioneiro {
	
	private ClientePrisioneiro(){}
	
	public static void main(String[] args){
	    //hospedeiro(host) do servidor: (null representa host local)
	    String host = (args.length < 1) ? null: args[0];
	    boolean confisaoPrisioneiro1 = true, confisaoPrisioneiro2 = true;
	    
	    try{
	    	
	      //obtém o stub para o registro
	      Registry registry = LocateRegistry.getRegistry(host);
	      
	      //obtém o stub para o objeto remoto(Ola) do registro:
	      Veredito stub = (Veredito) registry.lookup("Veredito");
	      
	      //Invoca o método remoto:
	      String resposta = stub.veredito(confisaoPrisioneiro1, confisaoPrisioneiro2);
	      System.out.println("reposta: " + resposta);
	    } catch (Exception e) {
	      System.err.println("Exceção no cliente" + e.toString());
	      e.printStackTrace();
	    }
	  }

}
