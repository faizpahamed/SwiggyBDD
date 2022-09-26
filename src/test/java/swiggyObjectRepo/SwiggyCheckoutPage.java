package swiggyObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwiggyCheckoutPage {
	
	
	public WebDriver driver;
	public SwiggyCheckoutPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Secure Checkout']") 	
	public WebElement secureCheckOut;

	
	@FindBy(xpath="//div[@class='_33KRy']")
	public List<WebElement> cartCheckoutItems;
	
	
	
	
}
