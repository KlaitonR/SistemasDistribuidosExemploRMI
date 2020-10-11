package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Veredito extends Remote{

	String veredito(boolean confisaoPrisioneiro1, boolean confisaoPrisioneiro2) throws RemoteException;
	
}
