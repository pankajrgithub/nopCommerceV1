package com.test;

import org.testng.annotations.Test;

public class ExceptionHandleTest {

	@Test(expectedExceptions = ArithmeticException.class)
	public void exceptionHandle()
	{
		int j=5;
		for(int i=0;i<=j;i++)
		{
			System.out.println(i/0); //handled arithmetic exception by defining expectedExceptions at Test
		}
	}
	
	
	
	@Test(invocationTimeOut = 2000)
	public void test()
	{
		int i=1;
		while(i==1)
		{
			System.out.println(i); //it will run infinite 
			//(invocationTimeOut = 2000) this will stop after 2 second of execution
		}
	}

}
