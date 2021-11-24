package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import okio.Timeout;

public class GoogleLogoTest {

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		 System.setProperty("webdriver.gecko.driver", "C://Users//pankaj.rawat//OneDrive - Renovite Technologies Inc//Desktop//WebDriver//FireFoxDriver/geckodriver.exe");
		   
	     driver=new FirefoxDriver();
	     driver.get("https://www.google.com");
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	@Test
	public void getTitle()
	{
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google","Not matched test failed");
	}
	
	@Test
	public void logoSearch()
	{
		boolean logo=driver.findElement(By.xpath("/html/body/div/div/div/img")).isDisplayed();
		
		System.out.println(logo);
	}
	
	@Test
	public void gmailLink()
	{
		boolean link=driver.findElement(By.linkText("Gmail")).isDisplayed();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
