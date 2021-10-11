package tier1;

import java.util.Scanner;


public class AdministratorTier1
{
    public static void main( String[] args )
    {
        try {
            Rest rest = new Rest();

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running){
                System.out.print("Enter account number: ");
                int accountNumber = scanner.nextInt();
                scanner.nextLine();
                if (rest.createAccount(accountNumber)){
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
