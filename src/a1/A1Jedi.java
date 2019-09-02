package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		// Parses data, using whitespace as a delimiter;
		Scanner scan = new Scanner(System.in);
		// Stores total number of items
		int item_count = scan.nextInt();
		
		// String array for items
		String[] all_items = new String[item_count];
		
		// double array for item prices
		double[] prices = new double[item_count];
		
		// Fills in previous two arrays
		for(int i=0; i<item_count; i++) {
			all_items[i] = scan.next();
			prices[i] = scan.nextDouble();
		}
		
		int cus_count = scan.nextInt();
		
		// integer arrays that corresponds, by index, to the store item
		// item_occ tracks the number of times an item is bought
		// cus_occ tracks how many customers buy a specific item. Only issue is that cuss_occ double tracks, triple tracks.. etc people
		
		int[] item_occ = new int[item_count];
		int[] cus_occ = new int[item_count];
		
		// This fills in the previous two arrays, so that they can be used later. 
 		for(int i=0; i < cus_count; i++) {
			scan.next();
			scan.next();
			// obtains number of items each customer purchased
			int count = scan.nextInt();
			
			//an array with number of reductions per 
			String[] order = new String[count];
			int[] nums = new int[count];
			for(int j=0; j<count; j++) {
				nums[j] = scan.nextInt();
				order[j] = scan.next();
	
				}
			int[] items_bought = new int[all_items.length];
			for(int j=0; j<count; j++) {
				for(int k=0; k<all_items.length; k++) {
					
					if(order[j].equals(all_items[k])) {
						item_occ[k] += nums[j];
						items_bought[k] = 1;
					}
				}
			}
			for(int j=0; j<all_items.length; j++) {
				if(items_bought[j] == 1) {
					cus_occ[j] ++;
				}
				
			}
			
 		}
 		// Done parsing data
 		scan.close();
 
 		// Prints out desired output
 		for(int i=0; i<all_items.length; i++) {
 			if(item_occ[i] == 0) {
 				System.out.println("No customers bought " + all_items[i]);
 				
 			} else {
 				System.out.println(cus_occ[i] + " customers bought " + item_occ[i] + " " + all_items[i]);
			}
		}

	}

}
