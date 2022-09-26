package swiggyObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwiggyTopNavigationMenu {

	
	
	public WebDriver driver;
	public SwiggyTopNavigationMenu(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='_2CgXb']//span[@class='_2vS77']")
	public WebElement navMenuCartCount;
}
