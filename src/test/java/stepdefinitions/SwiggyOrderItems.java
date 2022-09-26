package stepdefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swiggyObjectRepo.SwiggyCheckoutPage;
import swiggyObjectRepo.SwiggyLandingPage;
import swiggyObjectRepo.SwiggyOrderPage;
import swiggyObjectRepo.SwiggyRestarurantsPage;
import swiggyObjectRepo.SwiggyTopNavigationMenu;
import utility.ExcelReader;
import utility.Base ;
public class SwiggyOrderItems extends utility.Base{
	

	static SwiggyLandingPage slp ;
 	static SwiggyRestarurantsPage srp ;
 	 SwiggyOrderPage sop ;
 	SwiggyTopNavigationMenu snm;
 	SwiggyCheckoutPage scp;
 	Base bfl;
 	

	
 
 	
@Given("^user has entered (.+) on landing page$")	
public void user_has_entered_on_landing_page(String location) throws Throwable {
	       
			driver.get("https://www.swiggy.com/");
		 	SwiggyLandingPage slp = new SwiggyLandingPage(driver);
		 	Thread.sleep(2000);
		 	slp.deliveryLocationText.sendKeys(location);
		 	Robot robot = new Robot();
		 	Thread.sleep(2000);
		 	robot.keyPress(KeyEvent.VK_DOWN);
		 	robot.keyRelease(KeyEvent.VK_DOWN);
		 	robot.keyPress(KeyEvent.VK_ENTER);
		 	robot.keyRelease(KeyEvent.VK_ENTER);
	    }
@And("^user has enterd order page$")	
public void user_has_enterd_order_page() {
	   System.out.println("hello");
	 }

@And("^user has selected (.+) from page$")	 
public void user_has_selected_from_page(String restaurant) throws Throwable {
		 SwiggyOrderPage sop = new SwiggyOrderPage(driver);
		
		 Thread.sleep(4000);
		 sop.getRestaurant(restaurant).click();
	
	        
	    }
	
@When("^user clicks on add button of an (.+)$")
public void user_clicks_on_add_button_of_an(String item) throws Throwable {
		
			sop = new SwiggyOrderPage(driver);
			
			
        	Thread.sleep(3000);
        	sop.getItemAddBtn(item).click();
	        int modalPresent = driver.findElements(By.xpath("//div[@class='_1Kr-y _3EeZR']")).size();
			System.out.println(modalPresent);
	        
			if(modalPresent>0)
			{
				/*WebElement continue_1 = driver.findElement(By.xpath("//div[@class='uJZex']"));
				Thread.sleep(2000);
				continue_1.click();*/
				
				WebElement addItem = driver.findElement(By.xpath("//div[@class='_3coNr']"));
				addItem.click();
	       
	        }
			else {
				
											
				sop.cart.put(item, 1);
				}
			
			sop.selectdItem = item;
			}




@And("cart counter operator options are visible")
public void cart_counter_operator_options_are_visible() {
	   System.out.println("to be implemented");
}

@Then("verify item counter plus increases item count")
public void verify_item_counter_plus_increases_item_count() throws InterruptedException {
	Thread.sleep(2000);
	SwiggyOrderPage sop = new SwiggyOrderPage(driver);
	int  numberOfClicks=4;
	
	
	WebElement itemCount= sop.getItem(sop.selectdItem).findElement(By.xpath("//div[@class='_2zAXs _18lJJ']"));
	WebElement plus =sop.getItem(sop.selectdItem).findElement(By.xpath("//div[@class='_1ds9T _2Thnf']"));
	
	int initialItemCount= Integer.valueOf(itemCount.getText());
	
	
	for(int i =1;i<=numberOfClicks;i++)
		plus.click();
	
	int finalItemCount= Integer.valueOf(itemCount.getText());
	

	if(finalItemCount-initialItemCount==numberOfClicks)
	{
		System.out.println("item plus counter  is working ");
	}
		
}

@And("verify item counter minus decreases item count")
public void verify_item_counter_minus_decreases_item_count() throws InterruptedException {
	sop = new SwiggyOrderPage(driver);
	int  numberOfClicks=4;
	
	WebElement itemCount= sop.getItem(sop.selectdItem).findElement(By.xpath("//div[@class='_2zAXs _18lJJ']"));
	WebElement minus =sop.getItem(sop.selectdItem).findElement(By.xpath("//div[@class='_29Y5Z _2od4M']"));
	
	int initialItemCount= Integer.valueOf(itemCount.getText());
	for(int i =1;i<=numberOfClicks;i++)
		minus.click();
	
	int finalItemCount= Integer.valueOf(itemCount.getText());
	

	if(finalItemCount-initialItemCount==numberOfClicks)
	{
		System.out.println("item minus counter  is working ");
	}
}


@And("^user has no items added to cart$")
public void user_has_no_items_added_to_cart() throws Throwable {
	
	 snm =  new SwiggyTopNavigationMenu(driver);
	 int cartItemCount = Integer.valueOf(snm.navMenuCartCount.getText());
	 
	 Assert.assertTrue(cartItemCount==0);
}

@Then("^checkout option is visible$")
public void checkout_option_is_visible() throws Throwable {
	sop = new SwiggyOrderPage(driver);
	
		
	Assert.assertTrue(Base.checkElementisVisible(sop.checkoutBtn));
}

@And("^user can proceed to checkout page$")
public void user_can_proceed_to_checkout_page() throws Throwable {
	Thread.sleep(10000);
	sop = new SwiggyOrderPage(driver);
	sop.checkoutBtn.click();
	scp = new SwiggyCheckoutPage(driver);
	String expectedURL= "https://www.swiggy.com/checkout";
	//BasicFucntionLib.checkElementisVisible(scp.secureCheckOut);
	Thread.sleep(2000);
	String actualURl=driver.getCurrentUrl();
	System.out.println(expectedURL+"  "+actualURl);
	Assert.assertEquals(expectedURL, actualURl);
	
	
}


@Then("^verify user can see cart empty message$")
public void verify_user_can_see_cart_empty_message() throws Throwable {
	sop = new SwiggyOrderPage(driver);
	Thread.sleep(3000);
	String cartmsg = sop.cartEmptyLabel.getText().toLowerCase();
	 Assert.assertEquals("Cart empty message is displayed","cart empty",cartmsg.toLowerCase());
	
}

@When("user adds multiple items to cart")
public void user_adds_multiple_items_to_cart() throws InterruptedException, IOException {
	
	sop = new SwiggyOrderPage(driver);	
	Thread.sleep(3000);
	
	 ExcelReader Er=new ExcelReader();
	 Sheet orderSheet=Er.getWorksheet(System.getProperty("user.dir")+"//testData//TestData.xlsx", "Sheet1");
	 int cfooditem =Er.columnCount();
	 int rfooditem =Er.rowCount();
	 
	 
	 for(int k=1;k<=rfooditem;k++)
	 {
		// String snoTestCase=Er.readCell(TestCaseheet,0, k);
		 String foodName=Er.readCell(orderSheet,0, k);
		 int foodQty=Integer.valueOf(Er.readCell(orderSheet,1, k));
		 System.out.println(foodName);
		 System.out.println(foodQty);
		 sop.getItemAddBtn(foodName).click();
		 sop.selectdItem=foodName;
	     int modalPresent = driver.findElements(By.xpath("//div[@class='_1Kr-y _3EeZR']")).size();
	     Thread.sleep(2000);
	     
			if(modalPresent>0)
			{
				System.out.println("inside modal present code");
				/*WebElement continue_1 = driver.findElement(By.xpath("//div[@class='uJZex']"));
				Thread.sleep(2000);
				continue_1.click();
				Thread.sleep(2000);
				WebElement addItem = driver.findElement(By.xpath("//div[@class='_3coNr']"));
				addItem.click();*/	    
	       }
			else
			{
				WebElement plus =sop.getItemPlus(foodName);
				
				for(int j=2;j<=foodQty;j++)
					plus.click();
			}
			Thread.sleep(2000);
	 }
	 
}
   


/*public void user_adds_multiple_items_to_cart(DataTable dataTable) throws InterruptedException {
	
	sop = new SwiggyOrderPage(swiggyLandingPageSD.driver);	
	Thread.sleep(3000);
	
	List<List<String>> itemList = dataTable.asLists(String.class);
	for(List items : itemList)
	{
		for(int i=0;i<items.size();i++)
			{
				sop.getItemAddBtn(items.get(i).toString()).click();
				
		        int modalPresent = driver.findElements(By.xpath("//div[@class='_1Kr-y _3EeZR']")).size();
				System.out.println(modalPresent +"modal present");
		        
				if(modalPresent>0)
				{
					System.out.println("inside modal present code");
					/*WebElement continue_1 = driver.findElement(By.xpath("//div[@class='uJZex']"));
					Thread.sleep(2000);
					continue_1.click();
					Thread.sleep(2000);
					WebElement addItem = driver.findElement(By.xpath("//div[@class='_3coNr']"));
					addItem.click();
		       
		        }
				
				
		}
		
	}
	System.out.println("cart size"+sop.cart.size());
}*/
   



@Then("verify cart items same as checkout item")
public void verify_cart_items_same_as_checkout_item() throws IOException {
	
	ExcelReader Er=new ExcelReader();
	 Sheet orderSheet=Er.getWorksheet(System.getProperty("user.dir")+"//testData//TestData.xlsx", "Sheet1");
	 int cfooditem =Er.columnCount();
	 int rfooditem =Er.rowCount();
	 
	 HashMap<String, Integer> excelCart = new HashMap<>();
	 HashMap<String, Integer> swiggyCart = new HashMap<>();
	 for(int k=1;k<=rfooditem;k++)
	 {
		// String snoTestCase=Er.readCell(TestCaseheet,0, k);
		 String foodName=Er.readCell(orderSheet,0, k);
		 int foodQty=Integer.valueOf(Er.readCell(orderSheet,1, k));
		 System.out.println(foodName);
		 System.out.println(foodQty);
		 
		 excelCart.put(foodName, foodQty);
	 
	 
	 }
	
	 int cartSize =scp.cartCheckoutItems.size();
	for(int i=1;i<=cartSize;i++)
	{
		String food = driver.findElement(By.xpath("(//div[@class='_33KRy'])["+i+"]")).getText();
		int qty = Integer.valueOf(driver.findElement(By.xpath("(//div[@class='_2zAXs'])["+i+"]")).getText());
		swiggyCart.put(food, qty);
	}
	
	if(excelCart.equals(swiggyCart))	
		System.out.println("success");
	else
			
		System.out.println("failure");
	
	
	
}
}
   
	
	


