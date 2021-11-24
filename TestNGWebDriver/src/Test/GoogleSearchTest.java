package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTest {
WebDriver driver;
	@BeforeTest
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "C://Users//pankaj.rawat//OneDrive - Renovite Technologies Inc//Desktop//WebDriver//ChromeDriver//driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void googleSearch() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("java");
		
		Thread.sleep(2000);
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='wM6W7d']"));
		
		System.out.println(list.size());
		
	   for(int i=0;i<list.size();i++)
	   {
		   String item=list.get(i).getText();
		   System.out.println(item);
		   if(item.contains("java tutorial"))
		   {
			   list.get(i).click();
		   }
	   }
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
