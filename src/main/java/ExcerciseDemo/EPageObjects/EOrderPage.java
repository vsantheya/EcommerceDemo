package ExcerciseDemo.EPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EOrderPage {

	WebDriver driver;
	
	public EOrderPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".complete-header")
	WebElement confirmmsg;
	
	

	public String ConfirmationMessage()
	{
		String confirmationmsg =confirmmsg.getText();
		return confirmationmsg;
		
	}
}




