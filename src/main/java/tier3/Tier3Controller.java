/*
 * 12.09.2018 Original version
 */


package tier3;


import common.ITier3;
import model.Account;
import tier3.persistence.Persistence;
import tier3.persistence.PersistenceDB;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;


public class Tier3Controller
        extends UnicastRemoteObject
        implements ITier3 {
    private Persistence persistence;

    public Tier3Controller()
            throws RemoteException {
        try {
            startRegistry();
            startServer();
			System.out.println("Server started...");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        persistence = new PersistenceDB();
    }

    private void startRegistry() throws RemoteException {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Registry started");
        } catch (ExportException e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }

    private void startServer() throws MalformedURLException, RemoteException {
        Naming.rebind(T3_SERVICE_NAME, this);
        System.out.println("Server ready");
    }


    public Account getAccount(int accountNumber)
            throws RemoteException {
    	Account account= persistence.getAccount(accountNumber);
		if (account != null){
			System.out.println("Account " + accountNumber + " found.");
		}
		else{
			System.out.println("Account doesn't exist.");
		}
		return account;
    }


    public void updateAccount(Account account)
            throws RemoteException {
        if(persistence.getAccount(account.getNumber()) != null){
        	persistence.updateAccount(account);
		}
		else{
			System.out.println("Account doesn't exist.");
		}
    }

    @Override
    public boolean createAccount(Account account) throws RemoteException {
        if (persistence.getAccount(account.getNumber()) == null) {
            persistence.addAccount(account);
            System.out.println("Account " + account.getNumber() + " was created.");
            return true;
        }
        return false;
    }


}
