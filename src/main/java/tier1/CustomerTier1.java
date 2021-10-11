/*
 * 12.09.2018 Original version
 */


package tier1;

import common.ITier1;
import common.ITier2;
import model.Account;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;



public class CustomerTier1 extends UnicastRemoteObject implements ITier1
{
	private ITier2 tier2;

	CustomerTier1() throws RemoteException
	{
		super();
		try
		{
			this.tier2 = (ITier2) Naming.lookup(ITier2.T2_SERVICE_NAME);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean login(int accountNumber) throws RemoteException
	{
		return tier2.login(accountNumber,this);
	}

	public double getBalance(int accountNumber) throws RemoteException
	{
		return tier2.getBalance(accountNumber);
	}

	public boolean withdraw(int accountNumber, double amount)
			throws RemoteException
	{
		return tier2.withdraw(accountNumber,amount);
	}

	public void logout(int accountNumber) throws RemoteException
	{
		tier2.logout(accountNumber, this);
	}

	@Override public void updateBalance(double balance) throws RemoteException
	{
		System.out.println("Current balance: " + balance);
	}

	public static void main(String[] args)
	{

		try {
			CustomerTier1 ct1 = new CustomerTier1();

			Scanner scanner = new Scanner(System.in);
			boolean running = true;





			while (running){
				System.out.print("Enter account number to login, 0 for exit: ");
				int accountNumber = scanner.nextInt();
				scanner.nextLine();
				if (accountNumber == 0){
					System.out.println("Exiting");
					break;
				}
				boolean result = ct1.login(accountNumber);
				double balance = ct1.getBalance(accountNumber);
				System.out.println("Current balance: " + balance);
				while(result)
				{
					System.out.print("Enter amount to withdraw, 0 for exit: ");
					double amount = scanner.nextDouble();
					if (amount == 0)
					{
						ct1.logout(accountNumber);
						System.out.println("Logging out");
						break;
					}
					if (ct1.withdraw(accountNumber, amount))
					{
						System.out.println(amount + " was withdrawn");
					}
					else
					{
						System.out.println("Not possible");
					}
				}
			}

		} catch( Exception ex ) {
			ex.printStackTrace();
		}

	}


}
