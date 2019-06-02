package leetcode;

import java.util.Arrays;
import java.util.List;

public class ZigZagConversion {

	// Complete the sort_hotels function below.
    
	static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	return hotel_ids;
    }
	static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {
//        int[] arr = new int[callsTimes.size()];
//        int[] dep = new int[callsTimes.size()];
//		for(int i = 0;i<callsTimes.size();i++) {
//        	arr[i] = callsTimes.get(i).get(0);
//        	dep[i] = callsTimes.get(i).get(1);
//        }
		
		long[] arr = new long[]{1481122000, 1481122000, 1481122030};
		long[] dep = new long[]{1481122020, 1481122040, 1481122035};
		int n = arr.length;
		Arrays.sort(arr); 
		   Arrays.sort(dep); 
		   
		   // plat_needed indicates number of platforms 
		   // needed at a time 
		   int plat_needed = 1, result = 1; 
		   int i = 1, j = 0; 
		   
		   // Similar to merge in merge sort to process  
		   // all events in sorted order 
		   while (i < n && j < n) 
		   { 
		      // If next event in sorted order is arrival,  
		      // increment count of platforms needed 
		      if (arr[i] <= dep[j]) 
		      { 
		          plat_needed++; 
		          i++; 
		   
		          // Update result if needed  
		          if (plat_needed > result)  
		              result = plat_needed; 
		      } 
		   
		      // Else decrement count of platforms needed 
		      else
		      { 
		          plat_needed--; 
		          j++; 
		      } 
		   } 
		   
		return result - noOfCurrentAgents;

    }
	public String convert(String s, int numRows) {
		
		return s;   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		howManyAgentsToAdd(1, null);
	}

}
