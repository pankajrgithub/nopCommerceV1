package stepDefiniations;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

public class StepBaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage cp;
	public SearchCustomerPage searchCust;
	public Logger logger;
	public Properties prop;
	public static String getRandomString() {
		String randomStr=RandomStringUtils.randomAlphabetic(10);
		return randomStr;
		
	}
}
