package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorJuiz implements Veredito{

	public ServidorJuiz() {}
		
		public String veredito(boolean conficaoPrisioneiro1, boolean confisaoPrisioneiro2) {
			
			String veredito = "";
			
			if(conficaoPrisioneiro1 && confisaoPrisioneiro2) {
				veredito = "PENA: 5(cinco) anos de prisão!";
			}else if(!conficaoPrisioneiro1 && !confisaoPrisioneiro2) {
				veredito = "PENA: 3(três) anos de prisão!";
			}else if(conficaoPrisioneiro1 && !confisaoPrisioneiro2) {
				veredito = "Prisioneiro 1 - Não será aplicado pena, você está solto! \n"
						+ "Prisioneiro 2 - PENA: 10(dez) anos de prisão!";
			}else if(!conficaoPrisioneiro1 && confisaoPrisioneiro2) {
				veredito = "Prisioneiro 1 - PENA: 10(dez) anos de prisão! \n"
						+ "Prisioneiro 2 - Não será aplicado pena, você está solto!";	
			}
			
			return veredito;
			
		}
		
		public static void main (String args[]){
		    try{
		      //Criação e exportação do Objeto Remoto:
		      ServidorJuiz obj = new ServidorJuiz();
		      Veredito stub = (Veredito) UnicastRemoteObject.exportObject(obj,0);

		      //Registro do Objeto Remoto com Java RMI Registry:
		      Registry registry = LocateRegistry.getRegistry();
		      registry.bind("Veredito", stub);
		      
		      System.err.println("Servidor pronto . . .");
		      }catch (Exception e){
		      System.err.println("Exceçao no servidor:  " + e.toString());
		      e.printStackTrace();
		      }
		  }
	
}
