package tier1;

import java.rmi.RemoteException;
import java.util.Scanner;


public class ClerkTier1
{
    private Rest rest;

    public ClerkTier1()
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

    public boolean deposit(int accountNumber, double amount)
    {
        return rest.deposit(accountNumber, amount);
    }

    public static void main( String[] args )
    {
        try {
            ClerkTier1 ct1 = new ClerkTier1();

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running)
            {
                System.out.print("Enter account number to login, 0 for exit: ");
                int accountNumber = scanner.nextInt();
                scanner.nextLine();
                if (accountNumber == 0)
                {
                    System.out.println("Exiting");
                    break;
                }
                boolean result = ct1.login(accountNumber);
                double balance = ct1.getBalance(accountNumber);
                System.out.println("Current balance: " + balance);
                while (result)
                {
                    balance = ct1.getBalance(accountNumber);
                    System.out.println("Current balance: " + balance);
                    System.out.println("1. Withdraw\n2. Deposit\n*. Logout");
                    String choice = scanner.nextLine();
                    switch (choice)
                    {
                        case "1":
                            System.out.print("Enter amount to withdraw: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (ct1.withdraw(accountNumber, amount))
                            {
                                System.out.println(amount + " was withdrawn");
                            }
                            else
                            {
                                System.out.println("Not possible");
                            }
                            break;
                        case "2":
                            System.out.print("Enter amount to deposit: ");
                            amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (ct1.deposit(accountNumber, amount))
                            {
                                System.out.println(amount + " was deposited");
                            }
                            else
                            {
                                System.out.println("Not possible");
                            }
                            break;
                        default:

                            running = false;
                    }
                }
            }

        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
