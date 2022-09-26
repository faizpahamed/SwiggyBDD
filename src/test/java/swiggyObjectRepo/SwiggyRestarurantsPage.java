package swiggyObjectRepo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Base;

public class SwiggyRestarurantsPage {
	
	public WebDriver driver;
	public SwiggyRestarurantsPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='BZR3j']")
	public WebElement restaurantCounLabel;
	
	
	@FindBy(xpath="//div[@class='_1HEuF']")
	public WebElement restaurant;
	
	@FindBy(xpath="//div[@class='_3eFQ-']")
	public WebElement filter;
	
	@FindBy(xpath="//div[@class='_3vi_e']")
	public WebElement filterModal;
	
	@FindBy(xpath="//span[@class='SSFcO icon-close']")
	public WebElement closeModal;
	
	
	
	
	@FindBy(xpath = "//div[@class='_2CgXb']//a[@href='/search']")
	public WebElement searchLink;
	
	@FindBy(xpath = "//a[text()='Offers']")
	public WebElement offersLink;

	@FindBy(linkText = "Help")
	public WebElement helpLink;
	
	public int restaurantcount ;

	
	public int getRestaurantCount()
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='BZR3j']")));
		return Integer.valueOf(restaurantCounLabel.getText().split(" ")[0]);
	}
	
	
	public WebElement getFirstRestaurant()
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='BZR3j']")));
		
	return restaurant;
	}
	
	
	
	public WebElement getFilter()
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3eFQ-']")));
		
	return filter;
	}

	
	
	public WebElement filterModal()
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3eFQ-']")));
		
	return filterModal;
	}
	
	
	public WebElement closeModal()
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='SSFcO icon-close']")));
		
	return closeModal;
	}
	
	
	public WebElement searchLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchLink));
			
		return searchLink;
	}
	
	

	public WebElement offersLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(offersLink));
			
		return offersLink;
	}
	
	public WebElement helpLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(helpLink));
			return helpLink;
	}
	
	
}
