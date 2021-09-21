package tier1;

import common.ITier2;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class CustomerModel
{
  private ITier2 tier2;

  public CustomerModel()
  {
    try{
      tier2 = (ITier2) Naming.lookup(ITier2.T2_SERVICE_NAME);
    }
    catch (Exception e){
      System.err.println(e+" xD");
    }
  }

  public boolean login(int accountNumber) throws RemoteException
  {
    return tier2.accountExist(accountNumber);
  }

  public double getBalance(int accountNumber) throws RemoteException
  {
    return tier2.getBalance(accountNumber);
  }

  public void withdraw(int accountNumber, double amount){
    try{
      tier2.withdraw(accountNumber, amount);
    }catch (Exception e){
      System.err.println(e);
    }
  }

  public void logout(int accountNumber){
//    tier2.logout(accountNumber, this)
  }
}
