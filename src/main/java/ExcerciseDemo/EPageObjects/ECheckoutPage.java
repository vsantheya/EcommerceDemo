package ExcerciseDemo.EPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ECheckoutPage {

	
	WebDriver driver;
	
	public ECheckoutPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(css="input[placeholder='Zip/Postal Code']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	
	public EConfirmationPage GetDetails()
	{
		firstname.sendKeys("santheya");
		lastname.sendKeys("venkat");
		zipcode.sendKeys("12345");
		submit.click();
		EConfirmationPage confirmationpage = new EConfirmationPage(driver);
		return confirmationpage;

	}

}



