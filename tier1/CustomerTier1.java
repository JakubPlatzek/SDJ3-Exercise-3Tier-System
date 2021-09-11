/*
 * 12.09.2018 Original version
 */


package tier1;

import common.AdministratorRemote;
import common.CustomerRemote;

import java.rmi.Naming;
import java.util.Scanner;

import static common.CustomerRemote.T2_SERVICE_NAME;


public class CustomerTier1
{
	// Just a simple test driver. Should be client
	
	public static void main( String[] args )
	{
		try {
			CustomerRemote tier2 = (CustomerRemote) Naming.lookup("server");

			Scanner scanner = new Scanner(System.in);
			boolean running = true;

			while (running){
				System.out.print("Enter account number: ");
				int accountNumber = scanner.nextInt();
				scanner.nextLine();
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
