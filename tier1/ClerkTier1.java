package tier1;

import common.ITier1;
import common.ITier2;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


public class ClerkTier1 extends UnicastRemoteObject implements ITier1
{
    private ITier2 tier2;

    public ClerkTier1() throws RemoteException
    {
        super();
        try{
            tier2 = (ITier2) Naming.lookup(ITier2.T2_SERVICE_NAME);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean login(int accountNumber) throws RemoteException
    {
        return tier2.login(accountNumber, this);
    }

    public void logout(int accountNumber) throws RemoteException
    {
        tier2.logout(accountNumber,this);
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

    public boolean deposit(int accountNumber, double amount)
        throws RemoteException
    {
        return tier2.deposit(accountNumber, amount);
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
                            ct1.logout(accountNumber);
                            running = false;
                    }
                }
            }

        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }

    @Override public void updateBalance(double balance) throws RemoteException
    {
        System.out.println("Current balance: " + balance);
    }
}
