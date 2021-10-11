package tier2;

import common.ITier1;
import common.ITier2;
import common.ITier3;
import model.Account;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import static common.ITier3.T3_SERVICE_NAME;

public class Tier2Controller extends UnicastRemoteObject implements ITier2
{
  private ITier3 tier3;
  private Map<ITier1, Integer> connectedClients;

  public Tier2Controller() throws RemoteException
  {
    connectedClients = new HashMap<>();
    try {
      Naming.rebind("T2", this);

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

  @Override public double getBalance(int accountNumber) throws RemoteException
  {
    if (tier3.getAccount(accountNumber) == null) {
      return 0;
    }
    return tier3.getAccount(accountNumber).getBalance();
  }

  @Override public boolean login(int accountNumber, ITier1 client)
      throws RemoteException
  {
    boolean result = accountExist(accountNumber);
    if (result){
      connectedClients.put(client, accountNumber);
    }
    return result;
  }

  @Override public void logout(int accountNumber, ITier1 client)
      throws RemoteException
  {
    connectedClients.remove(client);
  }

  private void callback(Account account) throws RemoteException
  {
    for (Map.Entry<ITier1, Integer> entry: connectedClients.entrySet()){
      if (entry.getValue() == account.getNumber()){
        entry.getKey().updateBalance(account.getBalance());
      }
    }
  }

  @Override public boolean accountExist(int accountNumber)
      throws RemoteException
  {
    return tier3.getAccount(accountNumber) != null;
  }

  @Override
  public boolean deposit(int number, double balance) throws RemoteException {
    Account account = tier3.getAccount(number);
    if (account != null) {
      account.updateBalance(balance);
      tier3.updateAccount(account);
      callback(account);
      return true;
    }
    return false;
  }

  @Override
  public boolean withdraw(int accountNumber, double amount)
      throws RemoteException
  {
    Account account = tier3.getAccount(accountNumber);

    if (account == null)
      return false;
    else if (amount <= 0.0 || amount > account.getBalance())
      return false;
    else {
      account.updateBalance(-amount);
      tier3.updateAccount(account);
      callback(account);
      return true;
    }
  }


}
