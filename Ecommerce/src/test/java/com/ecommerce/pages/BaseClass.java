package com.ecommerce.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ecommerce.utilities.CaptureScreeshot;
import com.ecommerce.utilities.ConfigDataProvider;
import com.ecommerce.utilities.StartApplication;

public class BaseClass {
	
	public static ConfigDataProvider cdp;
	public WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter reporter;
	
	@BeforeSuite
	public void setUp()
	{
		Reporter.log("Test suite setup is started",true);
		
		cdp = new ConfigDataProvider();
		
		reporter = new ExtentHtmlReporter(new File("C:\\Users\\pankaj.koriya\\eclipse-workspace\\Ecommerce\\Ecommerce\\ExtentReports\\Ecommerce_" + CaptureScreeshot.getDateAndTime()+".html"));
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		Reporter.log("Test suite setup is completed",true);
	}
	
	@BeforeClass
	public void OpenApplication()
	{
		Reporter.log("Open browser setup is started",true);
		
		driver = StartApplication.OpenBrowser(driver, "chrome", "http://live.demoguru99.com/index.php/");
		
		Reporter.log("Browser is opened",true);
	}
	
	@AfterMethod
	public void testResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Testcase is passed", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreeshot.screenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("TestCase is failed", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreeshot.screenshot(driver)).build());
		}
		
		extent.flush();
		
		Reporter.log("Extent report is generated with screenshot",true);
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		
		Reporter.log("Browser is closed",true);
	}

}
