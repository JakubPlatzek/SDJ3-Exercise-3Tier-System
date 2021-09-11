package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdministratorRemote extends Remote {
    public static final String T2_SERVICE_NAME = "rmi://localhost/T2";

    boolean createAccount(int accountNumber) throws RemoteException;
}
