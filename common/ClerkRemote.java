package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClerkRemote extends Remote, CustomerRemote{
    public static final String T2_SERVICE_NAME = "rmi://localhost/T2";

    boolean deposit(int number, double balance) throws RemoteException;
    public boolean withdraw( int accountNumber, double amount ) throws RemoteException;
}
