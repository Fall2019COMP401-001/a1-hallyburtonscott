package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
	
		// Creates a list that will eventually contain all items 
		
		String[] master_item = new String[count];
		
		// Creates a list of all eventual prices of the items, respectively
		
		double[] master_costs = new double[count];
		
		// Adds the items/prices to their respective arrays
		for(int i=0; i<count; i++) {
			master_item[i] = scan.next();
			master_costs[i] = scan.nextDouble();
		}
		
		// gets the number of customers
		int customer_count = scan.nextInt();
		
		// Stores names in an array
		String[] names = new String[customer_count];
		
		// Stores their respective totals
		double[] totals = new double[count];
		
		
		// Fills in the previous two arrays
		for(int i=0; i< customer_count; i++) {
			names[i] = scan.next() + " " + scan.next();
			
			// number of items per customer
			int item_num = scan.nextInt();
			
			int[] amount = new int[item_num];
		
			double[] price = new double[item_num];
			
			for(int j=0; j<item_num; j++) {
				amount[j] = scan.nextInt();
				price[j] = swap(scan.next(), master_item, master_costs);
				
			}
			
			totals[i] = get_total(amount, price);
			
			
			//System.out.println(names[i] + get_total(amount, price));
		}
		scan.close();
		
		// Print result
		System.out.println("Biggest: " + get_max(names, totals));
		System.out.println("Smallest: " + get_min(names, totals));
		System.out.println("Average: " + String.format("%.2f", (double)get_average(totals, customer_count)));
	}
	
	
	/* swap 
	 * Returns the price of a specific fruit
	 *
	 * Inputs: String, String array, double array
	 * 
	 * Output: double 
	 * 
	 * Preconditions:
	 * String and double array must have the same length.
	 */
	
	static double swap(String type, String[] initial, double[] result) {
		for (int i=0; i<initial.length; i++) {
			if(type.equals(initial[i])) {
				return result[i];
			}
		}
		return 0;
	}
	
	/* get_total 
	 * Sums up the total amount spent by an individual customer
	 *
	 * Inputs: int array, double array
	 * 
	 * Output: double 
	 * 
	 * Preconditions:
	 * int and double array must have the same length.
	 */
	
	static double get_total(int[] amounts, double[] prices) {
		double sum = 0;
		for(int i=0; i<amounts.length; i++) {
			sum += amounts[i] * prices[i];
		}
		return sum;
	}
	
	/* get_average
	 * Returns the average amount spent
	 *
	 * Inputs: String, String array, double array
	 * 
	 * Output: double 
	 * 
	 * Preconditions:
	 * String and double array must have the same length.
	 */
	static double get_average(double[] totals, int number) {
		double sum = 0;
		for(int i=0; i<totals.length; i++) {
			sum += totals[i];
		}
		return sum / number;
		
	}
	/* get_max 
	 * Returns the name of the customer who spent the most
	 *
	 * Inputs: String array of names, double array corresponding to their respective totals
	 * 
	 * Output: String 
	 * 
	 * Preconditions:
	 * String and double array must have the same length.
	 */
	static String get_max(String[] names, double[] totals) {
		double max = 0;
		String name = "something went wrong";
		for(int i=0; i<names.length; i++) {
			if(max < totals[i]) {
				max = totals[i];
				name = names[i];
			}
		}
		return (name + " " + "(" + String.format("%.2f", (double)max) + ")");
	}
	/* get_min 
	 * Returns the name of the customer who spent the least
	 *
	 * Inputs: String array of names, double array corresponding to their respective totals
	 * 
	 * Output: String 
	 * 
	 * Preconditions:
	 * String and double array must have the same length.
	 */
	static String get_min(String[] names, double[] totals) {
		double min = Double.MAX_VALUE;
		String name = "something went wrong";
		for(int i=0; i<names.length; i++) {
			if(min > totals[i]) {
				min = totals[i];
				name = names[i];
			}
		}
		return (name + " " + " (" + String.format("%.2f", (double)min) + ")");
		
	}
}
