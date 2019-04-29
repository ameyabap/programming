package hackerrank;

import java.util.Arrays;

public class MarkAndToys {

	// Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        
    	Arrays.sort(prices);
    	int finalStartIndex = 0; int finalEndIndex = 0;
    	for(int i = 0;i<prices.length;i++){
    		int start = i;int end = 0; int currMax = 0; int currK = k;
    		for(int j = i ; j< prices.length;j++) {
    			if(currMax + prices[j] > k){
    				break;
    			}
    			currMax += prices[j];
				end = j;
    		}
    		if((end - start) > (finalEndIndex - finalStartIndex)) {
    			finalStartIndex = start;
    			finalEndIndex = end;
    		}
    		
    	}
    	return (finalEndIndex - finalStartIndex) + 1;
    }

	public static void main(String[] args) {
		System.out.println(MarkAndToys.maximumToys(new int[]{1, 12, 5,111, 200, 1000, 10}, 50));

	}

}
