package swiggyObjectRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwiggyOrderPage {
	
	public WebDriver driver;
	public SwiggyOrderPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[text()='Customisable']//parent::div[@class='_3L1X9 F8dpS']")
	public List<WebElement> cutomisableItems;
	
	
	@FindBy(xpath="//div[text()='ADD']//parent::div[@class='_3L1X9 F8dpS']")
	public List<WebElement> allitems;
	
	
	@FindBy(xpath="//div[@class='_3L1X9 F8dpS']//child::div[not(@class='_1C1Fl _23qjy')]")
	public List<WebElement> nonCustomisableitems ; 
	
	
	public HashMap<String, Integer> cart = new HashMap<>();
	public static String selectdItem;
	
	
	
	@FindBy(xpath="//button[(text()='Checkout')]")
	public WebElement checkoutBtn;
	
		
	@FindBy(xpath="//div[@class='_1pKFz Tqef9']")
	public WebElement cartEmptyLabel;
	//div[@class='_1pKFz Tqef9']
	
	
	public WebElement getFirsItem() throws InterruptedException
	{
		Thread.sleep(3000);
		
		return nonCustomisableitems.get(0);
		
	}
	
	public WebElement getItem(String itemName) throws InterruptedException
	{
		WebElement item = 				
				driver.findElement(By.xpath("(//h3[text()='"+itemName+"']//ancestor::div[@class='_2wg_t'])[1]"));
				return item;
	}
	
	public WebElement getItemPlus(String itemName) throws InterruptedException
	{
		WebElement item = 				
				driver.findElement(By.xpath("(//h3[text()='"+itemName+"']//ancestor::div[@class='_2wg_t']//div[@class='_1ds9T _2Thnf'])[1]"));
		
		return item;
	}
	
	
	
	
	public WebElement getItemAddBtn(String itemName) throws InterruptedException
	{
		WebElement item = 				
				driver.findElement(By.xpath("(//h3[text()='"+itemName+"']//ancestor::div[@class='_2wg_t'])[1]//div[@class='_1RPOp']"));
				return item;
		
	}
	
	public WebElement getRestaurant(String restaurantname) throws InterruptedException
	{
		WebElement restaurant = 				
		driver.findElement(By.xpath("//div[contains(text(),'"+restaurantname+"')]//ancestor::div[@class='_1HEuF']"));
		return restaurant;
		
	}
	
}
