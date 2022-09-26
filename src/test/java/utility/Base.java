package utility;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Runner.SwiggyLandingPageRunner;

public class Base {
	
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(SwiggyLandingPageRunner.class.getName());
	public static ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest features;
	
	public static boolean checkElementisVisible(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));  
		return ele.isDisplayed();
	
	}
	
	public static boolean checkUrl(String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.urlToBe(url)); 
			
	}
	
	
}
