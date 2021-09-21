package tier1;

import common.ITier2;

import java.rmi.Naming;
import java.util.Scanner;


public class ClerkTier1
{
    public static void main( String[] args )
    {
        try {
            ITier2 tier2 = (ITier2) Naming.lookup(ITier2.T2_SERVICE_NAME);

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running){
                System.out.println("1. Withdraw\n2. Deposit\n");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.print("Enter account number: ");
                        int accountNumber = scanner.nextInt();
                        scanner.nextLine();
                        double balance = tier2.getBalance(accountNumber);
                        System.out.println("Current balance: " + balance);
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        if (tier2.withdraw(accountNumber, amount)) {
                            System.out.println(amount + " was withdrawn");
                        } else {
                            System.out.println("Not possible");
                        }
                        break;
                    case "2":
                        System.out.print("Enter account number: ");
                        accountNumber = scanner.nextInt();
                        scanner.nextLine();
                        balance = tier2.getBalance(accountNumber);
                        System.out.println("Current balance: " + balance);
                        System.out.print("Enter amount to deposit: ");
                        amount = scanner.nextDouble();
                        scanner.nextLine();
                        if (tier2.deposit(accountNumber, amount)) {
                            System.out.println(amount + " was deposited");
                        } else {
                            System.out.println("Not possible");
                        }
                        break;
                    default:
                        running = false;
                }
            }

        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
