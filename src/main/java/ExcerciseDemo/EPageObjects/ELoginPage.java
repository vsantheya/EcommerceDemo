package ExcerciseDemo.EPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcerciseDemo.EAbstractComponents.EAbstractComponents;

public class ELoginPage extends EAbstractComponents {

	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement button;
	
	By login = By.cssSelector(".login_container");
	
	WebDriver driver;
	
	
	public ELoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goTo()
	{
		driver.get("https://www.saucedemo.com/");
		
	}

	public EProductListPage UserDetails(String name,String passcode)
	{
		EelementToAppear(login);
		username.sendKeys(name);
		password.sendKeys(passcode);
		button.click();
		EProductListPage productpage = new EProductListPage(driver);
		return productpage;
	}
}

