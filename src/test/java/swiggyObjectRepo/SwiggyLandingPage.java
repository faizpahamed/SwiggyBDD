package swiggyObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwiggyLandingPage {
	
	
	public WebDriver driver;
	public SwiggyLandingPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[@class='x4bK8']")
	public WebElement loginLink;
	
	
	
	@FindBy(xpath="//a[@class='r2iyh']")
	public WebElement singupLink;
	
	

	@FindBy(id="location")
	public WebElement deliveryLocationText;
	
	@FindBy(xpath="//button[@class='_1fiQt']")
	public  WebElement locateMe;
	
	@FindBy(xpath="//div[@class='_12S7_']")
	public WebElement loginContainer;
	
}
