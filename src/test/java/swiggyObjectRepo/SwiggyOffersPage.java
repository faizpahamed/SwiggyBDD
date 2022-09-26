package swiggyObjectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwiggyOffersPage {
	
	
	
	public WebDriver driver;
	public SwiggyOffersPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//div[text()='Offers for you']")
	public WebElement offersForYou;
	
	
	public WebElement offersForYou()
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(offersForYou));
		return offersForYou;
	}

}
