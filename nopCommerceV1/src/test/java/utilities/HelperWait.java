package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperWait {
WebDriver driver;
public  HelperWait(WebDriver driver)
{
	this.driver=driver;
}
	public void waitForElement(WebElement element,long timeOutInSecond) {
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSecond);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
