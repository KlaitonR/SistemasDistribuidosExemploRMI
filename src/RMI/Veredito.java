package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Veredito extends Remote{

	public String veredito(boolean confissaoPrisioneiro1, boolean confissaoPrisioneiro2) throws RemoteException;
	
}
