import java.util.Scanner;

public class TwoItemStore_20220808077 {

	public static void main(String[] args) {
	// Author : Sude Akıncı
	// Since : 09.11.2022
	Scanner scan = new Scanner(System.in);

	System.out.println("**********Store Inventory**********");
	
	System.out.print("\nEnter the name of product 1: ");	
	String name1 = scan.next();
	String output = name1.substring(0,1).toUpperCase() + name1.substring(1).toLowerCase();

    System.out.print("Enter the number of " + output + " we have: ");
	int num1 =  scan.nextInt();
	if (num1 <0)
		System.out.println("ERROR:Value cannot be negative.Exiting");
	else {
	    System.out.print("Enter the cost of " + output + " we have: ");	
	    float cost1 = scan.nextFloat();
	    if (cost1 < 0)
	    	System.out.println("ERROR:Value cannot be negative.Exiting");
	    else {
            System.out.print("\nEnter the name of product 2: ");	
		    String name2 = scan.next();
		    String output2 = name2.substring(0,1).toUpperCase() + name2.substring(1).toLowerCase();
            System.out.print("Enter the number of " + output2 + " we have: ");
		    int num2 =  scan.nextInt();
		    if (num2 < 0)
			    System.out.println("ERROE:Value cannot be negative.Exiting");
		    else {
	            System.out.print("Enter the cost of " + output2 + " we have: ");	
	            float cost2 = scan.nextFloat();
	            if(cost2 < 0)
	            	System.out.println("ERROR:Value cannot be negative.Exiting");
	            else {
	                System.out.println("\n**********Customer User Interface**********");
	                String stuff = "\n1 - " + output +  "\n"
	                		+ "2 - " + output2 + "\n"
	                		+ "0 - to checkout";
	                int customer;
	                int total1 = 0;
	                int total2 = 0;
	                do {
	    	            System.out.println("Welcome to our store.We have the following.Please enter what would you like: " + stuff);
	                    customer = scan.nextInt();
	    	            if(customer == 1) {
	    	            	System.out.print("How many " + output + " would you like?  ");
	    	                int quantity1 = scan.nextInt();
	    	            	if(quantity1 < 0)
	    	            		System.out.println("Invalid requested amount");
	    	            	else if(quantity1 > num1)
	    	            		System.out.println("We do not have that many remaining.");
	    	            	else {
	    	            		num1 = num1 - quantity1;
                                total1 += quantity1;
	    	                }
	    	            }
	    	            else if(customer == 2) {
	    	            	System.out.print("How many " + output2 + " would you like?  ");
	    	            	int quantity2 = scan.nextInt();
	    	            	if(quantity2 < 0)
	    	            		System.out.println("Invalid requested amount");
	    	            	else if(quantity2 > num2)
	    	                    System.out.println("We do not have that many remaining.");
	    	            	else {
	    	            	num2 = num2 - quantity2;
	    	            	total2 += quantity2;
	    	            	}
	    	            }
	    
	    	            else if (customer != 0 && customer != 1 && customer != 2)
	    	                System.out.println("Invalid menu Option");
	                }while(customer != 0);	
	    
	                System.out.println("\n**********Customer Total**********");
	                System.out.println(output + " - " + total1 + " x " + cost1 + " = " + total1*cost1 + "\n"
	                                 + output2 + " - " + total2 + " x " + cost2 + " = " + total2*cost2);
	                float total = total1*cost1 + total2*cost2;
	                System.out.println("----------------------------------\n" + "Total due - " + total);
	                
	                System.out.println("\n**********Final Report**********");
	                System.out.println("We now have the remaining products: \n" 
	                                  + output + " - " + num1 + "\n"
	                                  + output2 + " - " + num2);
	                
	            }
		    }
	    }
	    
	}
	scan.close();
	}
}
