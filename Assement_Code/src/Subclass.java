
public class Subclass {

	public static void main(String[] args) 
	{
		String message="Hello World!";

		String newMessage=message.substring(6, 12)+message.substring(12,6); //StringIndexOutOfBoundException
		System.out.println(newMessage); 
		
		
		
		
	}

}
