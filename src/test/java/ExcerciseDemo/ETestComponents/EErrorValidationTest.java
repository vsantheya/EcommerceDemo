package ExcerciseDemo.ETestComponents;


import java.io.IOException;
import org.testng.annotations.Test;

import ExcerciseDemo.EPageObjects.ELoginPage;




public class EErrorValidationTest  extends EBaseTest{
		
	@Test
	public void EErrorhandling() throws IOException
	{
		//String product = "Sauce Labs Bolt T-Shirt";
		//String name ="standard_user";
		//String passcode = "secret_sauce";
 
		
		
		ELoginPage loginpage = ELaunchApplication();
		loginpage.UserDetails("standard_user1","secret_sauce");
	
		
	}
	
	

}
