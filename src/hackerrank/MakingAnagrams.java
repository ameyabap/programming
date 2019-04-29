package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {

	
	static int makeAnagram(String a, String b) {
        Map<Character, Integer> charToFreq = new HashMap<Character, Integer>();
        for(int i = 0;i<a.length();i++)
        {
            Integer val = charToFreq.putIfAbsent(a.charAt(i), 1);
            if(val!=null) {
            	charToFreq.put(a.charAt(i), val+1);
            }
        }
        int matchingCharCount = 0;
        for(int i = 0;i<b.length();i++)
        {
        	if(charToFreq.containsKey(b.charAt(i)) && charToFreq.get(b.charAt(i)) > 0){
        		matchingCharCount++;
        		charToFreq.put(b.charAt(i), charToFreq.get(b.charAt(i)) - 1);
        	}
        }
        int noOfCharToRemove = (a.length() - matchingCharCount) + (b.length() - matchingCharCount);
        return noOfCharToRemove;
    }
	
	public static void main(String[] args) {
		System.out.println(new MakingAnagrams().makeAnagram("cde", "abc")); 

	}
	 public static int binarySearch(int[] array, int target) {
			int low = 0; int high = array.length;
			int mid = 0;
			while(low<=high){
					mid = (low + high)/2;
					if(array[mid] == target){
						return mid;
					}		
					if(target < array[mid]){
						high = mid -1;
					}else {
						low = mid + 1;
					}
			}
			return -1;
	 }
	 
	 

}
