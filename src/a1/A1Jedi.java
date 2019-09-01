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
		
		// int arrays that corresponds, by index, to the store item
		// item_occ tracks the number of times an item is bought
		// cus_occ tracks how many customers buy a specific item
		
		int[] item_occ = new int[item_count];
		int[] cus_occ = new int[item_count];
		
		
		// This fills in the previous two arrays, so that they can be used later. 
 		for(int i=0; i < cus_count; i++) {
			scan.next();
			scan.next();
			int count = scan.nextInt();
			
			for(int j=0; j<count; j++) {
				int num = scan.nextInt();
				String item = scan.next();
				
				for (int k=0; k < all_items.length; k++) {
					
					if(item.equals(all_items[k])) {
						// keeps continuous track of the values in the arrays
						item_occ[k] += num;
						cus_occ[k] ++;
					}
				
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
