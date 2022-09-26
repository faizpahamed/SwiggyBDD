package Runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import com.aventstack.extentreports.gherkin.model.Scenario;
import static utility.Base.features;
import static utility.Base.scenarioDef;
import io.cucumber.core.gherkin.Feature;
import utility.ExtentReporterNG;

public class NGTestListener implements ITestListener {
	ExtentTest test;
	
	
	
	ExtentReporterNG extentReportNg = new ExtentReporterNG();
	ExtentReports extent = ExtentReporterNG.getReportObject();
	public static Logger log = LogManager.getLogger(SwiggyLandingPageRunner.class.getName());
	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test Started");
		System.out.println("on test start");
		
		//extent.crea
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Test success.");
		scenarioDef.log(Status.PASS, result.getTestClass().getName()+": Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Test Failed.");
		/*features.log(Status.FAIL, result.getTestContext().getName()+"Test Failed");*/
		features.fail(result.getThrowable());
		scenarioDef.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		features= extent.createTest((Class<? extends IGherkinFormatterModel>) Feature.class,context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("Test Completed.");
		features.log(Status.INFO, "Feture check completed");
		extent.flush();
	}
		

}
