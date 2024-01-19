import java.util.Scanner;
public class StoreUsingArrays_20220808077 {
//Sude Akıncı
//01.12.2022
	public static int menu(String[] item ,double[] price,Scanner scan) {
		int choice;
		System.out.println("Please enter what you would like: ");
		capitalizeArray(item);
		
		for(int i = 0 , j = 0; i < item.length && j < price.length;i++ , j++) { //works if user choices at least one of the array items value
			String staff = (i + 1) + " - For " + item[i] + " " + "("+ price[j] + ")";
			System.out.println(staff);
		}
		System.out.println("0 - To check out");	
		choice = scan.nextInt();	
	    return choice; // returns the users choice
    }
	public static String returnedAmounts(double amount) {
	String text = "";
	    final int bills[] = {200, 100, 50, 20, 10, 5, 1}; // int amounts for Turkish lira
	    final double coins[] = {0.50,0.25,0.10,0.05,0.01}; // double amounts for kuruş
	     
	    for(int i = 0; i < bills.length;i++) 
	    	if(bills[i] <= amount) {
	    		int rem = (int)amount / bills[i]; //adds to rem(remainder) that how many values are in that
	    		text += rem + " - " + bills[i] + "  \n";
	    		amount %= bills[i]; //Subtracts the value from amount
	    	}
	    
	    for(int i = 0; i < coins.length;i++) 
	    	if(coins[i] <= amount) {
	    		int rem = (int)(amount / coins[i]);
	    		text += rem + " - " + coins[i] + "  \n";
	    		amount %= coins[i];
	    	}
	    
	    return text ; //returns how many times values have been used
	}
	public static void storeRun(String[] item,int[] quantity,double[] price) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Welcome tO our store, we have the following.");
		int choice;
		double total = 0;
		
		int[] copyQuantity = new int[quantity.length]; //equals copyQuantity's length to quantity
		for (int i = 0; i < quantity.length; i++) 
			copyQuantity[i] = quantity[i]; //equals copyQuantity's values to quantity
		
		do {
			choice = menu(item, price ,scan);
			if(!(choice > 0 && choice < item.length + 1) && choice != 0) 
			    System.out.println("ERROR: Invalid choice.");
			
			else if((choice > 0 && choice < 5)) {
			    System.out.print("How many " + item[choice - 1] + " would you like? ");
			    int amount = scan.nextInt();
			      if(amount < 0) 
			    	  System.out.println("Invalid requested amount. ");
			      else if(amount > quantity[choice - 1])
			    	  System.out.println("Invalid request");
			      else {
			    	  quantity[choice - 1] -= amount; //subtracts how many taken 
			    	  total += amount * price[choice - 1]; //adds amount to total
			      } 
			}
		}while(choice != 0);
		
		System.out.println("\n**********Customer Total**********");
		for(int i = 0; i < quantity.length; i++) 
			if(copyQuantity[i] != quantity[i]) 
        	System.out.println(item[i] + " - " + (copyQuantity[i] - quantity[i])  + " * " + price[i] +  " = " + (copyQuantity[i] - quantity[i]) * price[i]);
            
        System.out.println("----------------------------------\n" + "Total due: " + total);
       
        double amount;
        do { 
    	    System.out.println("\nPlease enter amount given "); 
            amount = scan.nextDouble();
            if(amount < total)
    	    System.out.println("Not enough payment given.");
	    }while(amount < total);
        System.out.println("Thank you for your business. Your change given is: ");
        if(amount == total)
    	    System.out.println("0");
        else
            System.out.println(returnedAmounts(amount - total)); 
	}
	
    //method for making only the first letter of the string uppercase and the rest lowercase.
	public static String capitalizeString(String text) {
		text = text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
		return text;
	}
	//method for making only the first letter of the each value in the array uppercase and the rest lowercase.
	public static void capitalizeArray(String[] item) {
		for (int i = 0; i < item.length; i++) 
			item[i] = capitalizeString(item[i]);
	}
	public static void main(String[] args) {
		int[] quantity = new int []{10, 15, 12, 30};                                       
		String[] item = new String[]{"bReaD","COLA","snİckers","ayrAn"};
		double[] price = new double[]{0.75, 2.5, 2.25, 1.0};
	    storeRun(item,quantity,price);
	}
}
