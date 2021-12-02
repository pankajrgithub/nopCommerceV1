package stepDefiniations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Steps extends StepBaseClass {

	@Before
	public void setUp() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("config.properties"); //file in read mood
		prop.load(fis);
		
		logger=Logger.getLogger("nopCommerceV1");
		PropertyConfigurator.configure("log4j.properties");
		
		String key=prop.getProperty("browser");
		if(key.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+prop.getProperty("chromepath"));
		driver=new ChromeDriver();
		}
		else if(key.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+prop.getProperty("firefoxpath"));
			   driver=new FirefoxDriver();
		}
		else if(key.equals("msedge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+prop.getProperty("edgepath"));
			   driver=new EdgeDriver();
		}
		else if(key.equals("ieserver")) {
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+prop.getProperty("iepath"));
			driver=new InternetExplorerDriver();
		}
		
		logger.info("**************************Luanching browser*************************");
	}
	
	
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
	   logger.info("**********************Open chrome browser*****************");
	   lp=new LoginPage(driver);
	   
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	  logger.info("Open URL's");
	  driver.get(url);
	  driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String u_email, String password) {
		logger.info("Enter User and Password");
		lp.getEmails(u_email);
		lp.getPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		logger.info("Click on login button");
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	   
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
			logger.info("Test Failed");
		}
		else {
			Assert.assertEquals(title,driver.getTitle());
			logger.info("Test Pass");
		}
		}


	@When("User Click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		logger.info("Click on logout link");
		lp.clickLogout();
		Thread.sleep(3000);
		
		
	}

	@Then("close browser")
	public void close_browser() {
	   logger.info("Close browser");
	   driver.quit();
	}
	
	//Add new customer sinppets method implementations 
	
/*	@Given("User lauch a Chrome browser")
	public void user_lauch_a_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User opens Url {string}")
	public void user_opens_url(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on login")
	public void click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	} */

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		cp=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",cp.getTitle());
		logger.info("Test Pass");
	} 

	@When("User click on Cutomer menu")
	public void user_click_on_cutomer_menu() throws InterruptedException {
	   logger.info("Click on Customers Menu");
	   cp.lnkMenuCustomers();
	   Thread.sleep(3000);
	}

	@When("click on Customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		logger.info("Click on Customers Menu Item");
		cp.lnkCustomer();
		Thread.sleep(3000);
	    	}

	@When("click on Add New button")
	public void click_on_add_new_button() throws InterruptedException {
		logger.info("Click on Add New Customer button");
		Thread.sleep(1000);
	    cp.btnAddNew();
	}

	@Then("User can view Add a new customer page")
	public void user_can_view_add_a_new_customer_page() throws InterruptedException {
		Thread.sleep(1000);
		if(driver.getPageSource().contains("Add a new customer")) {
			Assert.assertTrue(true);
			logger.info("Test Pass");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Test Failed");
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("Provides customer details");
		String emailRandom=getRandomString() +"@gmail.com" ;
		cp.setEmail(emailRandom);
		cp.setPassword("n8KVx99FUNVNmUpwaq");
		cp.setFirstName("Katie");
		cp.setLastName("perrey");
		cp.setGender("Female");
		cp.setDob("11/29/2010");
		cp.setCompany("abcd consultancy");
		cp.chkBtnTax();
		Thread.sleep(2000);
//		cp.setlstNewCustomersItem("Test store 2");
//		Thread.sleep(3000);
		cp.delRegistered();
		Thread.sleep(3000);
		cp.clickTxtList();
		Thread.sleep(2000);
		cp.setCustomerRoleItem("Guests");
		cp.setVendorItem();
		Thread.sleep(1000);
		cp.setAdminComment("all required details entered");
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("Click on Save Button");
		cp.clickOnSaveBtn();
		Thread.sleep(1000);
	   	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		
		Assert.assertEquals(msg,cp.getTitle());
		logger.info("Test Pass");
	}
	
	//Steps for Search user by emailID
	
	@When("Enter customer emailID")
	public void enter_customer_email_id() {
		logger.info("Provides customer email to search");
		searchCust=new SearchCustomerPage(driver);
		searchCust.searchEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		logger.info("click on search button");
		searchCust.clickSearchBtn(); 
		Thread.sleep(3000);
	}

	@Then("User should found email in the Search Table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		
		Assert.assertEquals(true, status);
		logger.info("Test Pass");
		Thread.sleep(2000);
	}
	
	//steps for search user by firstname/lastname
	
	@When("enter customer fisrtname")
	public void enter_customer_fisrtname() {
		logger.info("Provides User name");
		searchCust=new SearchCustomerPage(driver);
		searchCust.searchName("Brenda");
		
	}
	@When("enter customer lastname")
	public void enter_customer_lastname() {
		logger.info("Provides User Last name");
		searchCust.searchLastName("Lindgren");
	}

	@Then("User should found name in the Search Table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException {
		boolean status=searchCust.searchCustomerByName("Brenda Lindgren");
		
		Assert.assertEquals(status,true);
		logger.info("Test Pass");
		Thread.sleep(3000);
	}
	
	//Search customer by roleItem
/*
	@When("User clear the listitem")
	public void user_clear_the_listitem() throws InterruptedException {
		searchCust.clearRole();
		Thread.sleep(2000);
	}



	@When("User selects Role item")
	public void user_selects_role_item() throws InterruptedException {
		searchCust.clickSelectRole();	
		searchCust.selRolesToSearch("Guests");
		Thread.sleep(2000);
	}

	@Then("User should found records in table based on customer role")
	public void user_should_found_records_in_table_based_on_customer_role() {
		boolean guestStatus=searchCust.searchRoleByRole("Guests");
		
		Assert.assertEquals(true,guestStatus);
	}*/

}
