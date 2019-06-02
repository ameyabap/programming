package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaxSqureRoot2 {

	static Map<Integer, Integer> intToNoOfSqrRoots;
	static boolean hasCrossed;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//intToNoOfSqrRoots = new HashMap<Integer,Integer>();
		//System.out.println(squareRoots(255));
		//System.out.println(solution(10,20));
		//System.out.println(solution(6000,7000));
		//System.out.println(solution(2,1000000000));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));

	}
	public static int solution(int A, int B) {
        // write your code in Java SE 8
		intToNoOfSqrRoots = new HashMap<Integer,Integer>();
		int maxRoots = 0;
		int currNoOfRoots = 0;
		hasCrossed = false;
		for(int i = 2;i< B;i++){
			if(!hasCrossed) {
				findSqureRoots(i,A,B, 0);
			}
		}
		
		for (Map.Entry<Integer,Integer> entry : intToNoOfSqrRoots.entrySet())  {
//            System.out.println("Key = " + entry.getKey() + 
//                             ", Value = " + entry.getValue()); 
            maxRoots = Math.max(entry.getValue(), maxRoots);
    	} 		
		return maxRoots;
    }
	
	private static void findSqureRoots(int i, int a, int b, int j) {
		if(i > b) {
			hasCrossed = true;
			return;
		}
		if(intToNoOfSqrRoots.containsKey(i)) {
			if(i*i < Integer.MAX_VALUE) 
				findSqureRoots(i*i, a, b, intToNoOfSqrRoots.get(i) + 1);
		}else {
			if(i*i < Integer.MAX_VALUE)
				findSqureRoots(i*i, a, b, j+1);
			intToNoOfSqrRoots.put(i, j);
		}
		
	}
	public int lengthOfLastWord(final String A) {
        String[] parts = A.split(" ");
        if(parts.length == 0) {
            return 0;
        }else {
            return parts[parts.length - 1].length();
        }
    }
	
	 public int solve(String A) {
	        String vowels = "AEIOUaeiou";
	        int count = 0;
	        for(int i = 0;i<A.length();i++) {
	            
	            if(vowels.indexOf(A.charAt(i)) != -1) {
	            	count = count + (A.length() - i) + 1; 
	            }
	        }
	        return count;
	    }
	 
	 public static int isPalindrome(String A) {
		 int i = 0, j = A.length()-1;
		 while(i <= j) {
			 //int frontCharacter = Character.toLowerCase(A.charAt(i));
			 while(i<A.length() && !Character.isDigit(A.charAt(i)) &&  !Character.isLetter(A.charAt(i))){
				 i++;
//				 if(i<A.length())
//					 frontCharacter = (int)Character.toLowerCase(A.charAt(i));
			 }
			 if(i==A.length()) {
				 break;
			 }
			 
			 //int backCharacter = (int)Character.toLowerCase(A.charAt(i));
			 while(j>=0 && !Character.isDigit(A.charAt(j)) &&  !Character.isLetter(A.charAt(j))){
				 j--;
				 
			 }
			 if(j<0) {
				 break;
			 }
			 if(Character.toLowerCase(A.charAt(i)) != Character.toLowerCase(A.charAt(j))){
				 //System.out.println(A.charAt(i) + " " + A.charAt(j));
				 break;
			 }else {
				 i++;j--;
			 }
			 
			 
		 }
		 if(i>j) {
			 return 1;
		 }else {
			 return 0;
		 }
	 
	 }

}
