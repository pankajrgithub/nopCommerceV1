import java.util.Scanner;
public class ReverseNumb {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		
        int n, m,rev=0;
        System.out.println("Enter Any number to reverse:");
        n=s.nextInt();
/*        while(n!=0)
        {
		m=n%10;
		rev=rev *10 +m;
		n=n/10;
        }
        System.out.println("Number Reversed:"+rev);
         */
	    
   /*   do
        {
        	m=n%10;
    		rev=rev *10 +m;
    		n=n/10;
    		
        }while(n>0);
        System.out.println("Number Reversed:"+rev); */
        
        for(;n!=0;n=n/10)
        {
        	m=n%10;
        	rev=rev*10 +m;
        		
        }System.out.println("Number Reversed:"+rev);
        
       
    
        
	}

}
