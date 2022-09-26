package stepdefinitions;



import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;




import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import swiggyObjectRepo.SwiggyLandingPage;
import swiggyObjectRepo.SwiggyRestarurantsPage;

public class swiggyLandingPageSD extends utility.Base {
	
	 static SwiggyRestarurantsPage srp;
     static SwiggyLandingPage slp;
	


	@Before
	public static void setup(Scenario scenario) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver104.exe");
		
		scenarioDef= features.createNode(scenario.getName());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	
	@Given("user is on landing page")
	public void user_is_on_landing_page() throws Throwable {
	   driver.get("https://www.swiggy.com");
	   scenarioDef.createNode(new GherkinKeyword("Given"),"user is on landing page");
	   
			}
	
	@Given("user clicks on login link")
	 public void user_clicks_on_login_link() throws InterruptedException, Throwable {
		Thread.sleep(2000);
		 scenarioDef.createNode(new GherkinKeyword("Given"),"user clicks on login link");
		slp = new  SwiggyLandingPage(driver);
        slp.loginLink.click();
        Thread.sleep(2000);
 	
    }
	 
	 
	@Given("user clicks on locate me")
	public void user_clicks_on_locate_me() throws Throwable {
		 scenarioDef.createNode(new GherkinKeyword("Given"),"user clicks on locate me");
		 slp = new  SwiggyLandingPage(driver);
		slp.locateMe.click();
	}
	
	
	@Given("user clicks on signup link")
	public void user_clicks_on_signup_link() throws Throwable{
		 scenarioDef.createNode(new GherkinKeyword("Given"),"user clicks on signup link");
		System.out.println("user clicks on signup link");
	}
	
	@Then("verify user is taken to the restaurnt page")
	public void verify_user_is_taken_to_the_restaurnt_page() throws Throwable{
		
		boolean urlOk = checkUrl(driver.getCurrentUrl());
		scenarioDef.createNode(new GherkinKeyword("Then"),"verify user is taken to the restaurnt page");
		String errorMsg ="page is not landing page";
		Assert.assertTrue(urlOk, errorMsg) ;
		log.info("Successfully landed on restaurant page.");
		
		
		
	}
	@Then("verify Login modal popup shows")
	public void verify_login_modal_popup_shows() throws Throwable{
		scenarioDef.createNode(new GherkinKeyword("Then"),"verify Login modal popup shows");
		Assert.assertTrue(slp.loginContainer.isDisplayed());
		
	   
	}

	@Then("verify Login signup popup shows")
	public void verify_login_signup_popup_shows() throws Throwable{
	    // Write code here that turns the phrase above into concrete actions
		scenarioDef.createNode(new GherkinKeyword("Then"),"verify Login signup popup shows");
		System.out.println("verify Login signup popup shows");
		log.info("Successfully shown login popup shows.");
	}

	@Given("user clicks on find food")
	public void user_clicks_on_find_food() throws Throwable{
	    // Write code here that turns the phrase above into concrete actions
		 scenarioDef.createNode(new GherkinKeyword("Given"),"user clicks on find food");
		System.out.println("user clicks on find food");
		log.info("log find fod");
	}
	@Then("verify error message is shown")
	public void verify_error_message_is_shown() throws Throwable{
	    // Write code here that turns the phrase above into concrete actions
		scenarioDef.createNode(new GherkinKeyword("Then"),"verify error message is shown");
		System.out.println("verify error message is shown");
	}

	@After
	public static void tearDown()
	{
		driver.close();
		slp=null;
	}

}

