package swiggyObjectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwiggyHelpPage {
	
	public WebDriver driver;
	public SwiggyHelpPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//h1[text()='Help & Support']")
	public WebElement helpandSupport;
	
	
	public WebElement helpandSupport()
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(helpandSupport));
		return helpandSupport;
	}

}
