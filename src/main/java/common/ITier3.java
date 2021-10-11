/*
 * 12.09.2018 Original version
 */


package common;



import model.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ITier3
	extends Remote
{
	public Account getAccount(int accountNumber) throws RemoteException;
	
	public void updateAccount(Account account) throws RemoteException;

	public boolean createAccount(Account account) throws RemoteException;

	public static final String T3_SERVICE_NAME = "rmi://localhost/T3";
}
