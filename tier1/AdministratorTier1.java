package tier1;

import common.AdministratorRemote;
import common.CustomerRemote;

import java.rmi.Naming;
import java.util.Scanner;

import static common.CustomerRemote.T2_SERVICE_NAME;

public class AdministratorTier1
{
    public static void main( String[] args )
    {
        try {
            AdministratorRemote tier2 = (AdministratorRemote) Naming.lookup("server");

         /*   Scanner scanner = new Scanner(System.in);
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
            }*/
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
