package tier1;

import common.ITier2;

import java.rmi.Naming;
import java.util.Scanner;


public class AdministratorTier1
{
    public static void main( String[] args )
    {
        try {
            ITier2 tier2 = (ITier2) Naming.lookup(ITier2.T2_SERVICE_NAME);

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running){
                System.out.print("Enter account number: ");
                int accountNumber = scanner.nextInt();
                scanner.nextLine();
                if (tier2.createAccount(accountNumber)){
                    System.out.println(accountNumber + " was created");
                }
                else {
                    System.out.println(accountNumber + " was not created");
                }
            }
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
