package ExcerciseDemo.EPageObjects;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcerciseDemo.EAbstractComponents.EAbstractComponents;

public class EProductListPage extends EAbstractComponents {

	WebDriver driver;
	public EProductListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By productlist = By.cssSelector(".inventory_list");
	
	@FindBy(css=".inventory_item_name")
	List<WebElement> productNames;
	
	@FindBy(css="#add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement addtocart;
	
	@FindBy(css=".shopping_cart_link")
	WebElement carticonclick;
	
	public List<WebElement> AddtoCart()
	{
		EelementToAppear(productlist);
		return productNames;
	}

	public ECartPage GetProductName(String productName)
	{
		Optional<WebElement> selectedProduct = productNames.stream().filter(s->s.getText().equals(productName)).findAny();
		addtocart.click();
		carticonclick.click();
		ECartPage cartpage = new ECartPage(driver);
		return cartpage;
	}
}
