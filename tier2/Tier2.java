/*
 * 12.09.2018 Original version
 */


package tier2;

import tier1.CustomerTier1;

public class Tier2
{
	public static void main( String[] args )
	{
		try {
			ClerkTier2 clerkTier2 = new ClerkTier2();
			CustomerTier2 customerTier2 = new CustomerTier2();
			AdministratorTier2 administratorTier2 = new AdministratorTier2();
			
			System.out.println( "Tier2 ready" );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
