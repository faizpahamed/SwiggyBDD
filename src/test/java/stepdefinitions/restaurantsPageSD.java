package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.GherkinKeyword;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import swiggyObjectRepo.SwiggyHelpPage;
import swiggyObjectRepo.SwiggyLandingPage;
import swiggyObjectRepo.SwiggyOffersPage;
import swiggyObjectRepo.SwiggyRestarurantsPage;
import swiggyObjectRepo.SwiggySearchPage;

public class restaurantsPageSD extends utility.Base {
	
	private static WebDriver driver;
	static SwiggyRestarurantsPage srp ;
	static SwiggyLandingPage slp;
	static SwiggySearchPage ssp;
	static SwiggyHelpPage shp;
	static SwiggyOffersPage sop;

	 
	@Given("user is on restaurants page")
	public void user_is_on_restaurants_page() throws Throwable {
			driver =swiggyLandingPageSD.driver;
		 	driver.get("https://www.swiggy.com/");
		 	SwiggyLandingPage slp = new SwiggyLandingPage(driver);
		 	//scenarioDef.createNode(new GherkinKeyword("Given"),"User is on restaurants page");
		 	Thread.sleep(2000);
		 	slp.locateMe.click();
	}
	@Given("user clicks on the filter option")
	public void user_clicks_on_the_filter_option() throws Throwable {
		srp = new SwiggyRestarurantsPage(driver); 
		Thread.sleep(2000);
		//scenarioDef.createNode(new GherkinKeyword("Given"),"User clicks on the filter option");
		srp.getFilter().click();
		
		
	}
	@Then("verify filter modal popup shows up")
	public void verify_filter_modal_popup_shows_up() throws Throwable {
		Thread.sleep(2000);
		//scenarioDef.createNode(new GherkinKeyword("Then"),"Verify filter modal popup shows up").fail("fail");
		if(srp.filterModal().isDisplayed())
		{
			
			System.out.println("filter displayed");
			srp.closeModal.click();
		}
		else
		{System.out.println("modal not displayed");
		}
		Thread.sleep(2000);
		
	}
	
	
//	@Then("verify the restaurnts count displayed matches with actual count")
//	public void verify_the_restaurnts_count_displayed_matches_with_actual_count() throws InterruptedException {
//		System.out.println("verify the restaurnts count displayed matches with actual count");
//		srp = new SwiggyRestarurantsPage(driver); 
//		int itemcount=0; 
//		Thread.sleep(2000);
//		
//		Thread.sleep(2000);
//		while(itemcount<srp.getRestaurantCount())
//		{
//		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		itemcount= driver.findElements(By.xpath("//div[@class='_1HEuF']")).size();
//				
//				
//		}
//		
//		if(itemcount==srp.getRestaurantCount())
//		{
//			System.out.println("count matches");
//		}
//     }

	
	  @And("^user clicks on the search link$")
	    public void user_clicks_on_the_search_link() throws Throwable {
			Thread.sleep(2000);
			scenarioDef.createNode(new GherkinKeyword("And"),"User clicks on the search link");
			srp = new SwiggyRestarurantsPage(driver);
			srp.searchLink().click();
			ssp = new SwiggySearchPage(driver);
		 if(ssp.searchPlaceHodler().isDisplayed())
		 {
			System.out.println("search page is displayed"); 
		 }
		 else
		 {
			 System.out.println("search page is not displayed");  
		 }
		 
	    }

	  
	    @And("^user clicks on the offers link$")
	    public void user_clicks_on_the_offers_link() throws Throwable {
	    	//scenarioDef.createNode(new GherkinKeyword("And"),"User clicks on the offers link");
	    	srp = new SwiggyRestarurantsPage(driver);
	    	srp.offersLink().click();
	        
	    }

	    @And("^user clicks on the help link$")
	    public void user_clicks_on_the_help_link() throws Throwable {
	    	srp = new SwiggyRestarurantsPage(driver);
	    	srp.helpLink().click();
	    	//scenarioDef.createNode(new GherkinKeyword("And"),"User clicks on the help link");
	       
	    }

	
	
	   @Then("^verify search page shows up$")
	    public void verify_search_page_shows_up() throws Throwable {
		   ssp = new SwiggySearchPage(driver);
		  // scenarioDef.createNode(new GherkinKeyword("Then"),"Verify search page shows up");
		   Assert.assertTrue(ssp.searchPlaceHodler().isDisplayed()); 
	        
	    }

	    @Then("^verify offers page shows up$")
	    public void verify_offers_page_shows_up() throws Throwable {
	    	sop = new SwiggyOffersPage(driver);
	    	//scenarioDef.createNode(new GherkinKeyword("Then"),"Verify offers page shows up");
	    	Assert.assertTrue(sop.offersForYou().isDisplayed()); 
	       
	    }

	    @Then("^verify help page shows up$")
	    public void verify_help_page_shows_up() throws Throwable {
	    	shp = new SwiggyHelpPage(driver);
	    	//scenarioDef.createNode(new GherkinKeyword("Then"),"Verifyhelp page shows up");
	    	Assert.assertTrue(shp.helpandSupport().isDisplayed());
	        
	    }



}
