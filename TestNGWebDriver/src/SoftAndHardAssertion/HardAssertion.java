package SoftAndHardAssertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

	@Test
	public void testAssert()
	{
		Assert.assertEquals("selenium", "selenium");
		System.out.println("Test equals");	
	//	Assert.assertTrue(false); //we are failing this assertion here to test hard assertion
		
		Assert.assertTrue(true);
		System.out.println("Test true");
		
		Assert.assertFalse(false);
	    System.out.println("Test false");	
	}
}
