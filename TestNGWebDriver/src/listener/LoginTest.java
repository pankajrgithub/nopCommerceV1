package listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	void loginByEmail()
	{
		System.out.println("login by email");
		Assert.assertEquals("test", "test"); //true
	}
	
	@Test //(enabled=false)  //by using this parameter we are ignoring execution for this test
	void loginByFacebook()
	{
		System.out.println("login by facebook");
		Assert.assertEquals("Test", "test"); //false
	}
}
