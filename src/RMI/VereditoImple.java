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
			veredito = "PENA: 5(cinco) anos de pris�o!";
		}else if(!confissaoPrisioneiro1 && !confissaoPrisioneiro2) {
			veredito = "PENA: 3(tr�s) anos de pris�o!";
		}else if(confissaoPrisioneiro1 && !confissaoPrisioneiro2) {
			veredito = "Prisioneiro 1 - N�o ser� aplicado pena, voc� est� solto! \n"
					+ "Prisioneiro 2 - PENA: 10(dez) anos de pris�o!";
		}else if(!confissaoPrisioneiro1 && confissaoPrisioneiro2) {
			veredito = "Prisioneiro 1 - PENA: 10(dez) anos de pris�o! \n"
					+ "Prisioneiro 2 - N�o ser� aplicado pena, voc� est� solto!";	
		}
		
		return veredito;
	}
	
}
