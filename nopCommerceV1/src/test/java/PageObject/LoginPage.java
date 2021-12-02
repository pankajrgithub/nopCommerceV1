package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="Email")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpswd;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement btnlogout;
	
	public void getEmails(String email) {
		txtemail.clear();
		txtemail.sendKeys(email);
	}
	
	public void getPassword(String pass) {
		txtpswd.clear();
		txtpswd.sendKeys(pass);
	}
	
	public void clickLogin()	{
		btnlogin.click();
	}
	public void clickLogout() {
		btnlogout.click();
	}
}
