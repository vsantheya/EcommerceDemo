package ExcerciseDemo.ETestComponents;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcerciseDemo.EPageObjects.ECartPage;
import ExcerciseDemo.EPageObjects.ECheckoutPage;
import ExcerciseDemo.EPageObjects.EConfirmationPage;
import ExcerciseDemo.EPageObjects.ELoginPage;
import ExcerciseDemo.EPageObjects.EOrderPage;
import ExcerciseDemo.EPageObjects.EProductListPage;




public class ESubmitOrder  extends EBaseTest{
		
	@Test(dataProvider="test-data")
	
	public void EcommerceTest(HashMap<String,String> input) throws IOException
	{
		String product = "Sauce Labs Bolt T-Shirt";
		
		
		ELoginPage loginpage = ELaunchApplication();
		EProductListPage productpage =loginpage.UserDetails(input.get("email"),input.get("password"));
		productpage.AddtoCart();
		ECartPage cartpage = productpage.GetProductName(product);
		String list1 =cartpage.CheckoutDetails();
		Assert.assertEquals(list1, product);
		ECheckoutPage checkoutpage =cartpage.CheckoutClick();
		EConfirmationPage confirmationpage = checkoutpage.GetDetails();
		String itemlist =confirmationpage.ItemName();
		Assert.assertEquals(itemlist, product);
		EOrderPage orderpage = confirmationpage.CheckoutClick();
		String text =orderpage.ConfirmationMessage();
		Assert.assertEquals(text, "Thank you for your order!");
		tearDown();
	
		
	}
	
	
	@Test(dependsOnMethods={"EcommerceTest"})
	public void EcommerceTest2() throws IOException
	{
		//String product = "Sauce Labs Bolt T-Shirt";
		
		
		ELoginPage loginpage = ELaunchApplication();
		EProductListPage productpage =loginpage.UserDetails("performance_glitch_user","secret_sauce");
		productpage.AddtoCart();
		}
	
	/*
	@Test
	public void EcommerceTest3() throws IOException
	{		
		ELoginPage loginpage = ELaunchApplication();
		loginpage.UserDetails("visual_user","secret_sauce");
		
}

	*/
	
	@DataProvider(name="test-data")
	@Test
	public Object[][] EgetData() throws IOException
	{
		
		//return new String[][]  {{"visual_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
		
		/*
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("email","visual_user");
		data.put("password", "secret_sauce");
		
		HashMap<String,String> data1 = new HashMap<String,String>();
		data1.put("email","performance_glitch_user");
		data1.put("password", "secret_sauce");
		 return new Object[][] {{data},{data1}};
	*/
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\ExcerciseDemo\\data\\details.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
