package SoftAndHardAssertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestCase1 
{

	public void loginTest()
	{
		System.setProperty("webdriver.gecko.driver", "C://Users//pankaj.rawat//OneDrive - Renovite Technologies Inc//Desktop//WebDriver//FireFoxDriver/geckodriver.exe");
		   
	    WebDriver driver=new FirefoxDriver();
	    
	    driver.get("https://demo.guru99.com/test/newtours/index.php");
	    
	    WebElement userName= driver.findElement(By.name("userName"));
	    
	    WebElement password=driver.findElement(By.name("password"));
	    
	    WebElement btn=driver.findElement(By.name("submit"));
	    
	    Assert.assertTrue(userName.isDisplayed());
	    
	    userName.sendKeys("mercury");
	    
	    Assert.assertTrue(password.isDisplayed());
	    
	    password.sendKeys("mercury");
	    
	    Assert.assertTrue(btn.isDisplayed());
	    btn.click();
	    
	    //validation
	    String actual=driver.findElement(By.xpath("//h3[contains(text(),'Login Successfully')]")).getText();
	    
	    Assert.assertEquals(actual,"Login Successfully");
	    
	    System.out.println("Test pass");
	    
	    driver.close();
	    
	}
}
