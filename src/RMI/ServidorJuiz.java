package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorJuiz implements Veredito{

	public ServidorJuiz() {}
		
		public String veredito(boolean conficaoPrisioneiro1, boolean confisaoPrisioneiro2) {
			
			String veredito = "";
			
			if(conficaoPrisioneiro1 && confisaoPrisioneiro2) {
				veredito = "PENA: 5(cinco) anos de pris�o!";
			}else if(!conficaoPrisioneiro1 && !confisaoPrisioneiro2) {
				veredito = "PENA: 3(tr�s) anos de pris�o!";
			}else if(conficaoPrisioneiro1 && !confisaoPrisioneiro2) {
				veredito = "Prisioneiro 1 - N�o ser� aplicado pena, voc� est� solto! \n"
						+ "Prisioneiro 2 - PENA: 10(dez) anos de pris�o!";
			}else if(!conficaoPrisioneiro1 && confisaoPrisioneiro2) {
				veredito = "Prisioneiro 1 - PENA: 10(dez) anos de pris�o! \n"
						+ "Prisioneiro 2 - N�o ser� aplicado pena, voc� est� solto!";	
			}
			
			return veredito;
			
		}
		
		public static void main (String args[]){
		    try{
		      //Cria��o e exporta��o do Objeto Remoto:
		      ServidorJuiz obj = new ServidorJuiz();
		      Veredito stub = (Veredito) UnicastRemoteObject.exportObject(obj,0);

		      //Registro do Objeto Remoto com Java RMI Registry:
		      Registry registry = LocateRegistry.getRegistry();
		      registry.bind("Veredito", stub);
		      
		      System.err.println("Servidor pronto . . .");
		      }catch (Exception e){
		      System.err.println("Exce�ao no servidor:  " + e.toString());
		      e.printStackTrace();
		      }
		  }
	
}
