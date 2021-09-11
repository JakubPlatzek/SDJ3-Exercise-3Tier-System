package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CustomerRemote extends Remote {
    public static final String T2_SERVICE_NAME = "rmi://localhost/T2";

    public boolean withdraw( int accountNumber, double amount ) throws RemoteException;
}
