package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Identifies number of customers 
		int count = scan.nextInt();
		// Loops through all input in order to scan for all useful information 
		
		for(int i = 0; i < count; i++) {
			// first name 
			String first = scan.next();
			
			// first initial
			char initial = first.charAt(0);
			
			// last name 
			String last = scan.next();
			
			
			// Gets the number different types of objects the customer bought
			int item_total = scan.nextInt();
			
			// Stores numeric information. Even indices contain the number of the same item bought
			// Odd indices contain the price of each individual item
			double[] values = new double[2 * item_total];
			
			for(int j=0; j < values.length; j+=2) {
				values[j] = scan.nextInt();
				scan.next();
				values[j+1] = scan.nextDouble();
			}
			// Keeps track of the running total of each customer 
			double individual_total = 0; 
			
			// Updates the total 
			for(int j=0; j<values.length; j+=2)	{
				individual_total += (values[j]*values[j+1]);
				
			}
			
			// Prints out each line of relevant information
			System.out.println(initial + ". " + last + ": " + individual_total);
				
			}
		// done parsing data
		scan.close();
		}
	
		
	}

