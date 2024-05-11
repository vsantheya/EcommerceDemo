package ExcerciseDemo.EPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EConfirmationPage {

	WebDriver driver;
	
	public EConfirmationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(className="inventory_item_name")
	WebElement itemname;
	
	@FindBy(id="finish")
	WebElement checkoutbtn;

	public String ItemName()
	{
		String checkoutname =itemname.getText();
		return checkoutname;
	}
	
	public EOrderPage CheckoutClick()
	{
		checkoutbtn.click();
		EOrderPage orderpage = new EOrderPage(driver);
		return orderpage;
	
	}
	
	
	
}





