package swiggyObjectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Base;

public class SwiggySearchPage {
	
	public WebDriver driver;
	public SwiggySearchPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@placeholder='Search for restaurants and food']")
	public WebElement searchPlaceHodler;
	
	
	public WebElement searchPlaceHodler()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchPlaceHodler));
			return searchPlaceHodler;
	}
	
}
