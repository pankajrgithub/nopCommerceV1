package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnotation {

	//Annotation declare with 
	
//	Set System properties
//	launch chrome  browser
//	open URl
//	login into application
//	Get title of page
//	logout from application
//	close the browser
//	clear all browser cookies
//	PASSED: getTitle
	
	@BeforeSuite
	public void setUp()
	{
		System.out.println("@BeforeSuite: Set System properties");
	}
	@BeforeTest
	public void launchBrowser()
	{
	System.out.println("@BeforeTest:launch chrome  browser");	
	}
	
	@BeforeClass
	public void url()
	{
		System.out.println("@BeforeClass:open URl");
	}
	
	//sequence to execute test
//	@BeforeMethod
//	@Test
//	@AfterMethod	
	
	@BeforeMethod
	public void login()
	{
		System.out.println("@BeforeMethod:login into application");
	}
	
	@Test //Sequence 1
	public void getTitle()
		{
			System.out.println("@Test:Get title of page");
		}
	
	@Test //Sequence 2
	public void searchText()
	{
		System.out.println("@Test search test");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("@AfterMethod:logout from application");
	}
	
	@AfterClass
	public void close()
	{
		System.out.println("@AfterClass:close the browser");
	}
	
	@AfterTest
	public void cleanCookies()
	{
		System.out.println("@AfterTest:clear all browser cookies");
	}
	}
	

