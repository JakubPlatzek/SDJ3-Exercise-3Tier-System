/*
 * 12.09.2018 Original version
 */


package tier1;

import common.ITier2;

import java.rmi.Naming;
import java.util.Scanner;



public class CustomerTier1
{
	public static void main(String[] args)
	{
		try {
			ITier2 tier2 = (ITier2) Naming.lookup(ITier2.T2_SERVICE_NAME);

			Scanner scanner = new Scanner(System.in);
			boolean running = true;

			while (running){
				System.out.print("Enter account number: ");
				int accountNumber = scanner.nextInt();
				scanner.nextLine();
				double balance = tier2.getBalance(accountNumber);
				System.out.println("Current balance: " + balance);
				System.out.print("Enter amount to withdraw: ");
				double amount = scanner.nextDouble();
				if (tier2.withdraw(accountNumber,amount)){
					System.out.println(amount + " was withdrawn");
				}
				else{
					System.out.println("Not possible");
				}
			}

		} catch( Exception ex ) {
			ex.printStackTrace();
		}

	}
}
