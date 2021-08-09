package Inheritance;


class P
{
	public void m1()
	{
	System.out.println("Parent Class");	
	}
}

class C extends P //Is-A relationship Inheritance

{
	public void m2()
	{
		System.out.println("Child Class");
	}
}

public class Test {
	public static void main(String[] args) 
	{
		P p1=new P();
		p1.m1();   //valid
//		p1.m2();   //unvalid
		
		C c1=new C();
		
		c1.m1();  //valid
		c1.m2();  //valid
		
		P pp=new C();
		
		pp.m1();          //parent class can hold child object but can access only parent properties.
//		pp.m2(); //invalid
		
/*		C cc=new P(); //child class can't hold parent object
		cc.m1();
		cc.m2();  */


	}

}
