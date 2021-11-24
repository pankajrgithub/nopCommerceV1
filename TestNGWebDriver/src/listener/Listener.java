package listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter{

	
	public void onTestSatrt(ITestResult tr) {
		System.out.println("Test started");
	}
	
	public void onTestSuccess(ITestResult tr) {
	
		System.out.println("Test passed");
	}
	
	public void onTestFailure(ITestResult tr) {
	System.out.println("Test failed");
	}
	
	public void onTestSkipped(ITestResult tr) {
		System.out.println("Test Skipped");
	}
}


