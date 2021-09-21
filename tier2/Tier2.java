/*
 * 12.09.2018 Original version
 */


package tier2;

import common.ITier2;
import tier1.CustomerTier1;

import java.rmi.server.UnicastRemoteObject;

public class Tier2
{
	public static void main( String[] args )
	{
		try {
			Tier2Controller t2c = new Tier2Controller();
			
			System.out.println( "Tier2 ready" );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
