/*
 * 12.09.2018 Original version
 */


package tier2;

import common.AdministratorRemote;
import common.ITier3;
import model.Account;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static common.ITier3.T3_SERVICE_NAME;

public class AdministratorTier2
        extends UnicastRemoteObject
        implements AdministratorRemote {
    private ITier3 tier3;

    public AdministratorTier2()
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
    public boolean createAccount(int accountNumber) throws RemoteException {
        if (tier3.getAccount(accountNumber) == null) {
            Account account = new Account(accountNumber, 0.0);
            return tier3.createAccount(account);
        } else {
            System.out.println("Account with this number already exists.");
            return false;
        }
    }

}
