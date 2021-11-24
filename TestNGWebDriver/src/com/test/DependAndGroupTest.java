package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependAndGroupTest {
 
	@BeforeMethod
	public void setUp()
	{
		System.out.println("set brower path");
	}
	
	@Test(priority=1)
	public void login()
	{
		System.out.println("login sucessful");
	/*	int i=10;
		int r=i/0;  //java.lang.ArithmeticException: / by zero
		//rest of dependent test cases will be skip if this will be failed
		 
		 */
	}
	
	@Test(priority=2,groups="search page", dependsOnMethods ="login")
	public void getTitle()
	{
		System.out.println("login sucessful");
	}
	
	@Test(priority=3,groups="search page",dependsOnMethods ="login")
	public void verifyLogo()
	{
		System.out.println("login sucessful");
	}
	
	@Test(priority=4,groups="search page",dependsOnMethods ="login")
	public void verifyGmailLink()
	{
		System.out.println("link available");
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("close window browser");
	}
}
