package Predicate;

import java.util.function.Predicate;

public class Demo1 {

	public static void main(String[] args) 
	{
		Predicate<Integer> p=i->(i>10);  //to invoke lambda expression here we used Predicate interface function with type integer
		
		System.out.println(p.test(20)); //test is method used by Predicate function interface. it contains only one argument at a time
		System.out.println(p.test(9));

	}

}
