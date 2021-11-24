package Extent_Report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class GenerateExtentReport 
{
   WebDriver driver;
   
   ExtentReports extent; //specify the location of the report
   ExtentTest test; //what details should be populated in the report 
   
   ExtentHtmlReporter htmlReporter; //look and feel
   
   @BeforeTest
   public void setExtent()
   {
	   htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/MyReport.html");
	   
	   
	   htmlReporter.config().setDocumentTitle("Automation Report"); //title of the report
	   
	   htmlReporter.config().setReportName("Functional Report"); //name of the report
	   
	   htmlReporter.config().setTheme(Theme.STANDARD); //set them of HTML report file
	   
	   extent=new ExtentReports();
	   extent.attachReporter(htmlReporter);
	   
	   extent.setSystemInfo("HostName", "localhost");
	   extent.setSystemInfo("OS","Windows");
	   extent.setSystemInfo("Tester Name", "Pankaj");
	   extent.setSystemInfo("Browser", "Chrome");
   }
   
   @AfterTest
   public void endReport()
   {
	   extent.flush();
   }
   
   @BeforeMethod
   public void setUp()
   {
	   System.setProperty("webdriver.gecko.driver", "C://Users//pankaj.rawat//OneDrive - Renovite Technologies Inc//Desktop//WebDriver//FireFoxDriver/geckodriver.exe");
	   
	   driver=new FirefoxDriver();
	   driver.get("https://demo.nopcommerce.com/");
   }
   @Test
   public void nonpCommerceTitle()
   {
	   test=extent.createTest("nonpCommerceTitle"); //will create newTest
	   
	   String title=driver.getTitle();
	   
	   Assert.assertEquals(title, "nopCommerce demo store");
   }
   
   @Test
   public void nopCommercelogoTest()
   {
	   test=extent.createTest("nopCommercelogoTest"); //will create newTest
	   
	  
	   WebElement logo=driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
	   
	   Assert.assertTrue(logo.isDisplayed());
	   
   }
   @Test
   public void nopCommereceLoginTest()
   {
	   test=extent.createTest("nopCommereceLoginTest");
	   
	   Assert.assertTrue(true);
   }
   
   @AfterMethod
   public void tearDown(ITestResult result) throws Exception
   {
	   if(result.getStatus()==ITestResult.FAILURE) {
		   test.log(Status.FAIL, "Test Case Failed"+ result.getName()); //to Add Name in Extent report
		   test.log(Status.FAIL, "Test Case Failed"+ result.getThrowable()); //to add error/Exception in extent report
		   
		   //call static method by class name directly z
		   String screenShotPath=GenerateExtentReport.getScreenshot(driver,result.getName()); 
		   test.addScreenCaptureFromPath(screenShotPath);
	   }
	   
	   else if(result.getStatus()==ITestResult.SKIP) {
		   test.log(Status.SKIP, "Test Case Skip"+ result.getName());
	   }
	   else if(result.getStatus()==ITestResult.SUCCESS) {
		   test.log(Status.PASS, "Test Case Pass"+ result.getName());
	   }
   }
   
   public static String getScreenshot(WebDriver driver, String screenShotName) throws IOException
   {
	   String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	   
	   TakesScreenshot ts= (TakesScreenshot)driver;
	   
	   File source= ts.getScreenshotAs(OutputType.FILE);
	   
	   String destination=System.getProperty("user.dir")+"/Screenshots/" +screenShotName +dateName + ".png";
	   File finalDestination=new File(destination);
	  
	//   FileUtils.copyFile(finalDestination,source); has been updated to below
	   FileHandler.copy(source,finalDestination);
	   return destination;
   }
   
}
