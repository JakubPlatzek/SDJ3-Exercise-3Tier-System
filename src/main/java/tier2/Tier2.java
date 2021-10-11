/*
 * 12.09.2018 Original version
 */


package tier2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tier2
{
	public static void main( String[] args )
	{
		SpringApplication.run(Tier2.class, args);
			System.out.println( "Tier2 ready" );
	}
}
