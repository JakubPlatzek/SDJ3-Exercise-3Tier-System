package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITier2 extends Remote {
    public static final String T2_SERVICE_NAME = "rmi://localhost/T2";

    boolean deposit(int number, double balance) throws RemoteException;
    public boolean withdraw( int accountNumber, double amount ) throws RemoteException;
    boolean createAccount(int accountNumber) throws RemoteException;
    double getBalance(int accountNumber) throws RemoteException;
    boolean login(int accountNumber, ITier1 client) throws RemoteException;
    void logout(int accountNumber, ITier1 client) throws RemoteException;
    boolean accountExist(int accountNumber) throws RemoteException;
}
