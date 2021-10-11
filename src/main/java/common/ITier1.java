package common;

import model.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITier1 extends Remote
{
  void updateBalance(double balance) throws RemoteException;
}
