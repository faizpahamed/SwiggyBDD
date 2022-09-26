package Automaion.SwiggyBDD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwiggyTestCases {
	
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver103.exe");
		WebDriver  driver;
		
		driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");	
		driver.manage().window().maximize();
	}

}
