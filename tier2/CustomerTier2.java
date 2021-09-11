/*
 * 12.09.2018 Original version
 */


package tier2;

import common.CustomerRemote;
import common.ITier3;
import model.Account;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static common.ITier3.T3_SERVICE_NAME;

public class CustomerTier2
        extends UnicastRemoteObject
        implements CustomerRemote
{
    private ITier3 tier3;

    public CustomerTier2()
            throws RemoteException {
        try {
            Naming.rebind("server", this);

            tier3 = (ITier3) Naming.lookup(T3_SERVICE_NAME);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    @Override
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
}
