/*
 * 12.09.2018 Original version
 */


package tier1;

import common.ITier2;
import javafx.application.Application;
import javafx.stage.Stage;
import tier1.view.ViewHandler;
import tier1.viewModel.ViewModelFactory;

import java.rmi.Naming;
import java.util.Scanner;



public class CustomerTier1 extends Application
{
	@Override public void start(Stage stage) throws Exception
	{
		CustomerModel cm = new CustomerModel();
		ViewModelFactory vmf = new ViewModelFactory(cm);
		ViewHandler vh = new ViewHandler(vmf);
		vh.start(stage);
//		try {
//			ITier2 tier2 = (ITier2) Naming.lookup(ITier2.T2_SERVICE_NAME);
//
//			Scanner scanner = new Scanner(System.in);
//			boolean running = true;
//
//			while (running){
//				System.out.print("Enter account number: ");
//				int accountNumber = scanner.nextInt();
//				scanner.nextLine();
//				double balance = tier2.getBalance(accountNumber);
//				System.out.println("Current balance: " + balance);
//				System.out.print("Enter amount to withdraw: ");
//				double amount = scanner.nextDouble();
//				if (tier2.withdraw(accountNumber,amount)){
//					System.out.println(amount + " was withdrawn");
//				}
//				else{
//					System.out.println("Not possible");
//				}
//			}
//
//		} catch( Exception ex ) {
//			ex.printStackTrace();
//		}

	}
}
