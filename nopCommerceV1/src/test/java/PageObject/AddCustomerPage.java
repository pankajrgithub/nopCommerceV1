package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.HelperWait;

public class AddCustomerPage{
	HelperWait helperwait;
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	//identifications of Web Elements 
	
	//Add New Customer Page
	By menuCustomers=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By linkCustomer=By.xpath("//a[@href='/Admin/Customer/List']/p");
	By addbtn=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	
	By txtemail=By.id("Email");
	By txtpwd=By.id("Password");
	By txtf_name=By.id("FirstName");
	By txtlast_name=By.id("LastName");
	By rdGenderMale=By.xpath("//label[contains(text(),'Male')]");
	By rdGenderFemale=By.xpath("//label[contains(text(),'Female')]");
	By txtdob=By.id("DateOfBirth");
	By txtcompany=By.id("Company");
	By chktax=By.id("IsTaxExempt");
	//By lstNewsletter=By.xpath("//li[contains(text(),'Test store 2')]");
	//By lstCustomerrole=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div");
	
	By lstDelRegis=By.xpath("//span[@title='delete']");
	By txtlstItem=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div");
	By lstAdminRole=By.xpath("//*[@id='9e8c22dd-fdb8-430c-ab50-f8493b1184a6']");
	By lstForumRole=By.xpath("/html/body/div[6]/div/div[2]/ul/li[2]");
	By lstGuestRole=By.xpath("//li[contains(text(),'Guests')]");
	By lstRegRole=By.xpath("/html/body/div[6]/div/div[2]/ul/li[4]");
	By lstVendorRole=By.xpath("/html/body/div[6]/div/div[2]/ul/li[5]");
	
	By lstvendor=By.id("VendorId");
	By txtAdmincomment=By.id("AdminComment");
	By btnsave=By.name("save");
	By lstNewsLetter=By.xpath("//*[@id='0f3ec4f4-e510-404a-9028-af1cdae51502']");
	By lstNewsletter=By.xpath("/html/body/div[5]/div/div[2]/ul/li[2]");
	//Actions on WebElement 
	public String getTitle() {
		String title=driver.getTitle();
		return title;
	}
	public void lnkMenuCustomers() {
		driver.findElement(menuCustomers).click();
	}
	
	public void lnkCustomer() {
		WebElement menuItem=driver.findElement(linkCustomer);
		menuItem.click();
	}
	
	public void btnAddNew() {
		WebElement addbutton=driver.findElement(addbtn);
		addbutton.click();
		
	/*	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[o].click();", addbutton); */
	}
	//Actions on New Customer Page web-elements 
	
	public void setEmail(String email) {
		driver.findElement(txtemail).sendKeys(email);
	}
	public void setPassword(String pass) {
		driver.findElement(txtpwd).sendKeys(pass);
	}

	public void setFirstName(String fname) {
		driver.findElement(txtf_name).sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		driver.findElement(txtlast_name).sendKeys(lname);
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			driver.findElement(rdGenderMale).click();
		}
		else if(gender.equals("Female")) {
			driver.findElement(rdGenderFemale).click();
		}
		else {
			driver.findElement(rdGenderMale).click();
		}
	}

	public void setDob(String dob) {
		driver.findElement(txtdob).sendKeys(dob);
	}
	
	public void setCompany(String org) {
		driver.findElement(txtcompany).sendKeys(org);
	}
	
	public void chkBtnTax() {
		driver.findElement(chktax).click();
	}
	
	public void setlstNewCustomersItem(String news) {
		WebElement listItem;
		if(news.equals("Your store name")) {
			listItem=driver.findElement(lstNewsLetter);
		}
		else if(news.equals("Test store 2")) {
			listItem=driver.findElement(lstNewsletter);
		}
		else {
			listItem=driver.findElement(lstNewsLetter); 
		}
		listItem.click();
	
	}
	public void delRegistered() throws InterruptedException {
		
		driver.findElement(lstDelRegis).click();
		Thread.sleep(2000);
	}
	
	public void clickTxtList() throws InterruptedException {
		driver.findElement(txtlstItem).click();
		Thread.sleep(2000);
	}
	
	
	public void setCustomerRoleItem(String role) throws InterruptedException {
		WebElement lisItem;
		Thread.sleep(3000);
		if(role.equals("Administrators")) {
			lisItem=driver.findElement(lstAdminRole);
		}
		else if(role.equals("Forum Moderators")) {
			lisItem=driver.findElement(lstForumRole);
		}
		else if(role.equals("Guests")) {
			lisItem=driver.findElement(lstGuestRole);
		}
		else if(role.equals("Registered")) {
			lisItem=driver.findElement(lstRegRole);
		}
		else if(role.equals("Vendors")) {
			lisItem=driver.findElement(lstVendorRole);
		}
		else {
			lisItem=driver.findElement(lstGuestRole);
		}
	//	lisItem.click();
		//alternative to click on web-elements
		//lisItem.clear();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",lisItem);
	}
	
	public void setVendorItem() {
		WebElement listvendor=driver.findElement(lstvendor);
		Select listitem=new Select(listvendor);
		listitem.selectByIndex(1);
	}
	
	public void setAdminComment(String comment) {
		driver.findElement(txtAdmincomment).sendKeys(comment);
	}
	
	public String setPageContains() {
		String source=driver.getPageSource();
		return source;
	}
	public void clickOnSaveBtn() {
		driver.findElement(btnsave).click();
	}
	
	
}
