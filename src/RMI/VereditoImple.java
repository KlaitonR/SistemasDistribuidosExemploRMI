package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VereditoImple extends UnicastRemoteObject implements Veredito{

	private static final long serialVersionUID = 1L;

	protected VereditoImple() throws RemoteException{
		super();
	}
	
	@Override
	public String veredito(boolean confissaoPrisioneiro1, boolean confissaoPrisioneiro2) throws RemoteException {
		
		String veredito = "";
		
		if(confissaoPrisioneiro1 && confissaoPrisioneiro2) {
			veredito = "PENA: 5(cinco) anos de prisão!";
		}else if(!confissaoPrisioneiro1 && !confissaoPrisioneiro2) {
			veredito = "PENA: 3(três) anos de prisão!";
		}else if(confissaoPrisioneiro1 && !confissaoPrisioneiro2) {
			veredito = "Prisioneiro 1 - Não será aplicado pena, você está solto! \n"
					+ "Prisioneiro 2 - PENA: 10(dez) anos de prisão!";
		}else if(!confissaoPrisioneiro1 && confissaoPrisioneiro2) {
			veredito = "Prisioneiro 1 - PENA: 10(dez) anos de prisão! \n"
					+ "Prisioneiro 2 - Não será aplicado pena, você está solto!";	
		}
		
		return veredito;
	}
	
}
