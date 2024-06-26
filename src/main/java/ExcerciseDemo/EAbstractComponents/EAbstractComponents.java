package ExcerciseDemo.EAbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EAbstractComponents {

WebDriver driver;

	
	public EAbstractComponents(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
}

	public void EelementToAppear(By findBy)
	{
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	
}
