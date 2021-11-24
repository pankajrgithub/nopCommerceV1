package SoftAndHardAssertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	SoftAssert softAssert=new SoftAssert(); //it is for first Test
    
	SoftAssert softAssert1=new SoftAssert(); //created separate instance so that it 1st instance will impact second test
	@Test
	public void softAssertTest()
	{
		softAssert.assertEquals("selenium", "selenium");
		System.out.println("Test equals");
		
		softAssert.assertTrue(false); //we are failing this assertion here to test hard assertion
		System.out.println("test failed");
    	
		softAssert.assertTrue(true);
		System.out.println("Test true");
		
		softAssert.assertFalse(false);
	    System.out.println("Test false");	
	    
	    softAssert.assertAll();
	}
	
	@Test
	public void softTest()
	{
		softAssert1.assertEquals("test", "test");
		System.out.println("Test pass");
		softAssert1.assertAll();
	}
}
