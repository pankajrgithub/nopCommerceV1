
 class Demo_String
 {

    public static void main(String[] args) 
	 {
		String message="hello";
		print(message);
		message+="world";
		print(message);

	}
   static void print(String message)
    {
    	System.out.print(message);
    	message+="";
    } 

}
