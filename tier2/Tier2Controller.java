/*
 * 12.09.2018 Original version
 */


package tier2;


import common.AdministratorRemote;
import common.ClerkRemote;
import common.CustomerRemote;
import common.ITier3;
import model.Account;


import static common.CustomerRemote.T2_SERVICE_NAME;
import static common.ITier3.T3_SERVICE_NAME;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Tier2Controller
        extends UnicastRemoteObject
        implements CustomerRemote, AdministratorRemote, ClerkRemote {
    private ITier3 tier3;

    public Tier2Controller()
            throws RemoteException {
        try {
            Naming.rebind("server", this);

            tier3 = (ITier3) Naming.lookup(T3_SERVICE_NAME);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }


    public boolean withdraw(int accountNumber, double amount)
            throws RemoteException {
        Account account = tier3.getAccount(accountNumber);

        if (account == null)
            return false;
        else if (amount <= 0.0 || amount > account.getBalance())
            return false;
        else {
            account.updateBalance(-amount);
            tier3.updateAccount(account);

            return true;
        }
    }

    @Override
    public boolean createAccount(int accountNumber) throws RemoteException {
        if (tier3.getAccount(accountNumber) == null) {
            Account account = new Account(accountNumber, 0.0);
            return tier3.createAccount(account);
        } else {
            System.out.println("Account with this number already exists.");
            return false;
        }
    }

    @Override
    public boolean deposit(int number, double balance) throws RemoteException {
        Account account = tier3.getAccount(number);
        if (account != null) {
            account.updateBalance(balance);
            tier3.updateAccount(account);
            return true;
        }
        return false;
    }
}
