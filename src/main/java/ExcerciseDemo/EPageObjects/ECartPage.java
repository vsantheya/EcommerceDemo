package ExcerciseDemo.EPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ECartPage {

	WebDriver driver;
	
	public ECartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".inventory_item_name")
	WebElement productnameList;
	
	@FindBy(id="checkout")
	WebElement checkoutbutton;
	
	
	public String CheckoutDetails()
	{
		String list =productnameList.getText();
		return list;
	}
	
	public ECheckoutPage CheckoutClick()
	{
		checkoutbutton.click();
		ECheckoutPage checkoutpage = new ECheckoutPage(driver);
		return checkoutpage;
		
	}
	
	

}
