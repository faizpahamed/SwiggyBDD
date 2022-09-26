package Runner;


import org.junit.runner.RunWith;
//import org.testng.annotations.AfterClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.CucumberOptions;






@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/features/swiggyLandingPage.feature",
		glue = {"stepdefinitions"},
				plugin = {"pretty", "html:target/Destination.html"}
		)
//"pretty", "html:target/Destination.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
// extends AbstractTestNGCucumberTests
public class SwiggyLandingPageRunner extends AbstractTestNGCucumberTests {
	
	


}
