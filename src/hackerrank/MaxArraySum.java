package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class MaxArraySum {

	public String solve(String A, int B) {
        Map<Character, Integer> charFreq = new HashMap<Character, Integer>();
		for(int i = 0;i<A.length();i++) {
			if(charFreq.containsKey(A.charAt(i))){
				charFreq.put(A.charAt(i), charFreq.get(A.charAt(i)) + 1);
			}else {
				charFreq.put(A.charAt(i), 1);
			}
		}
        int offSet;String result = "";
        boolean canIncChar = false;
		for(int i = 0;i<A.length();i++) {
			canIncChar = charFreq.get(A.charAt(i)) % 2 == 0; 
			if(canIncChar) {
				offSet = (((int)'a'  - (int)A.charAt(i)) + B )%26;  
			}else {
				offSet = (((int)'a'  - (int)A.charAt(i)) - B )%26;
			}
			result += ((char)((int)'a' + (int)A.charAt(i) + offSet)); 
		}
        
        return result;
        
        
        
    }
	// Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(arr.length-1, arr[arr.length-1]);
    	for(int i = 0;i<arr.length;i++) {
    		map.put(i, arr[i]);
    	}
    	int max = Integer.MAX_VALUE;
    	for(int i = arr.length-2;i>=0;i--) {
    		for(int j = i+1;j<arr.length;j++) {
    			if(arr[i]+map.get(j) > map.get(i)) {
    				map.put(i,arr[i]+map.get(j));
    			}
    		}
    		if(map.get(i)>max){
    			max = map.get(i);
    		}
    	}
    	return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MaxArraySum().solve("abccba", 2);
	}

}
