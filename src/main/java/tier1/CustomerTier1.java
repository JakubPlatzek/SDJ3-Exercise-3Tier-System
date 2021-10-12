/*
 * 12.09.2018 Original version
 */


package tier1;

import java.rmi.RemoteException;
import java.util.Scanner;



public class CustomerTier1
{
	private Rest rest;

	CustomerTier1()
	{
		rest = new Rest();
	}

	public boolean login(int accountNumber)
	{
		return rest.getBalance(accountNumber) >= 0.0;
	}

	public double getBalance(int accountNumber)
	{
		return rest.getBalance(accountNumber);
	}

	public boolean withdraw(int accountNumber, double amount)
	{
		return rest.withdraw(accountNumber,amount);
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
					balance = ct1.getBalance(accountNumber);
					System.out.println("Current balance: " + balance);
					System.out.print("Enter amount to withdraw, 0 for exit: ");
					double amount = scanner.nextDouble();
					if (amount == 0)
					{
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
