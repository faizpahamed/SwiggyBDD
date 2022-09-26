package utility;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG extends Base{

	public static String path =System.getProperty("user.dir")+"\\reports\\index.html";
	public static ExtentReports getReportObject()
	{
		
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Swiggy Automation Test Results");
		reporter.config().setDocumentTitle("Test Results");
		//reporter.config().setTheme(Theme.DARK);
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Faiz Ahamed");
		return extent;
		
	}
	
	public void ExtentReportScreenshot() throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scr.toPath(),new File(path+"screenshot.png").toPath());
	}
}
