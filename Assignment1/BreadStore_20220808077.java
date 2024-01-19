import java.util.Scanner;

public class BreadStore_20220808077 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("***Cupcake Inventory***");
		
		//Cupcake İnventory
		System.out.println(" Enter the amount of cupcake we have:");
		int amountOwner = input.nextInt();
    if (!(amountOwner >= 0)) 
    	System.out.println(" ERROR :Value cannot be negative.Exiting.");

    if (amountOwner >= 0) {
        System.out.println(" Enter the cost of a cupcake:");
        double cost = input.nextDouble();
      if (cost < 0) 
        System.out.println(" ERROR :Cost cannot be a negative number.Exiting.");   
    
    //Customer's Side
      if (cost >= 0) {
        System.out.println("***Customer User Interface*** ");
        System.out.print(" Welcome to our cupcake store.We have" + " " + amountOwner );
        System.out.println(" cupcakes available.");   
        System.out.println("How many would you like?");
      
        int amountCustomer = input.nextInt();
    
      if (!(amountCustomer > 0)) 
      	System.out.println(" ERROR :The amount of customer wanted cannot be negative or 0.Exiting.");	
      
      else if (amountCustomer > amountOwner) {
      	System.out.print(" ERROR :We do not have that many remaining.");
        System.out.println(" We now have " + amountOwner + " cupcakes remaining.");
      }
      else{
      	System.out.println(" Your total cost is " + (amountCustomer * cost));
      	System.out.println(" Thank you for shopping with us today");
      	System.out.println(" We now have " + (amountOwner - amountCustomer) + " cupcakes remaining.");
      }
      }   
	
    }
    input.close();
  }
}