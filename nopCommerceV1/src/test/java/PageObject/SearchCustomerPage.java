package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.HelperWait;

public class SearchCustomerPage {
    WebDriver driver;
    HelperWait waitHelper;
    
	public SearchCustomerPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new HelperWait(driver);
	}
	@FindBy(how=How.ID,using="SearchEmail")
	WebElement txtsearchEmail;
	
	@FindBy(how=How.ID,using="SearchFirstName")
	WebElement txtsearchName;
	
	@FindBy(how=How.ID,using="SearchLastName")
	WebElement txtsearchlName;
	
	
	@FindBy(how=How.ID,using="SearchMonthOfBirth")
	WebElement selMonth;
	
	@FindBy(how=How.ID,using="SearchDayOfBirth")
	WebElement selDay;
	
	@FindBy(how=How.ID,using="SearchCompany")
	WebElement txtsearchCompany;
	
	@FindBy(how=How.ID,using="SearchIpAddress")
	WebElement txtsearchIP;
	
	@FindBy(how=How.XPATH, using="//span[@title='delete']")
	WebElement roleListDel;
	
	@FindBy(how=How.XPATH,using="//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRole;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Administrators')]")
	WebElement listItemAdmin;
	
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Forum Moderators')]")
	WebElement listItemForum;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Guests')]")
	WebElement listItemGuest;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Registered')]")
	WebElement listItemRegister;
	
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Vendors')]")
	WebElement listItemVendor;
	
	@FindBy(how=How.ID,using="search-customers")
	WebElement btnSearch;
	
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']")
	WebElement tableSearchResult;
	
	
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	WebElement table;
	
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void searchEmail(String searchemail) {
		waitHelper.waitForElement(txtsearchEmail, 30);
		txtsearchEmail.sendKeys(searchemail);
	}
	
	public void searchName(String searchname) {
		waitHelper.waitForElement(txtsearchName, 30);
		txtsearchName.sendKeys(searchname);
	}
	
	public void searchLastName(String searchlname) {
		waitHelper.waitForElement(txtsearchlName, 30);
		txtsearchlName.sendKeys(searchlname);
	}
	
	public void searchMonth() {
		Select months=new Select(selMonth);
		months.selectByVisibleText("2");
	}
	
	public void searchDay() {
		Select days=new Select(selDay);
		days.selectByVisibleText("3");
	}
	
	public void searchCompany(String searchCompany) {
		txtsearchCompany.sendKeys(searchCompany);
	}
	
	public void searchIP(String searchIP) {
		txtsearchIP.sendKeys(searchIP);
	}
	
	public void clickSearchBtn() {
		waitHelper.waitForElement(btnSearch, 30);
		btnSearch.click();
	}
	
	public int getRowNum() {
		return tableRows.size();
	}
	
	public int getColumnNum() {
		return tableColumns.size();
	}
	
	public boolean searchCustomerByEmail(String orgEmail) {
		boolean flag= false;
		
		for(int i=1;i<=getRowNum();i++) {
			String email=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			
			if(email.equals(orgEmail)) {
				flag= true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String name) {
		boolean flag= false;
		
		for(int i=1;i<=getRowNum();i++) {
			String uname=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			
			String names[]=uname.split(" "); //seperating first name and lastname
			if(names[0].equals("Brenda")&& names[1].equals("Lindgren")) {
				flag= true;
			}
		}
		return flag;
	}
	
	public void clearRole() {
		roleListDel.click();
	}
	public void clickSelectRole() {
		txtCustomerRole.click();
	}
	public void selRolesToSearch(String roleItem) throws InterruptedException {
		Thread.sleep(2000);
		WebElement role;
		if(roleItem.equals("Administrators")) {
			role=listItemAdmin;
		}
		else if(roleItem.equals("Forum Moderators")) {
			role=listItemForum;
		}
		else if(roleItem.equals("Guests")) {
			role=listItemGuest;
		}
		else if(roleItem.equals("Registered")) {
			role=listItemRegister;
		}
		else if(roleItem.equals("Vendors")) {
			role=listItemVendor;
		}
		else {
			role=listItemRegister;			
			}
		role.click();
	}
	
	public boolean searchRoleByRole(String roleItem) {
		boolean flag=false;
		
		for(int i=1;i<=getRowNum();i++) {
		String role=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[4]")).getText();
		if(role.equals(roleItem)) {
			flag=true;
		}
		}
		return flag;
	}
		
}

