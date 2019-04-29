package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TheGridSearch {

	public int lengthOfLongestSubstring(String s) { 
        int strSize = s.length();
        if(strSize == 0) {
            return 0;
        }
        if(strSize == 1) {
            return 1;
        }
        Map<Character, Integer> seenChars;
        int currSize;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i< strSize;i++) {
            currSize = 0;
            seenChars = new HashMap<Character, Integer>();
            for(int j = i; j<strSize;j++) {
                char ch = s.charAt(j);
            	if(seenChars.containsKey(ch)) {
            		i = seenChars.get(ch) + 1;
                	break;
                }
                currSize++;
                seenChars.put(ch, j);
            }
            max = (currSize > max) ? currSize : max;
        }
        return max;
    }
	static String gridSearch(String[] G, String[] P) {
		int rowsP = P.length;int colsP;
		if(rowsP != 0) {
			colsP = P[0].length();
		}
		for(int i = 0;i<G.length;i++){
			for(int j = 0;j< G[i].length();j++) {
				if(G[i].charAt(j) == P[0].charAt(0)) {
					if(searchAt(G,P,i,j)){
						return "YES";
					}
				}
			}
			
		}
		return "NO";
        
    }
	private static boolean searchAt(String[] g, String[] p, int startI, int startJ) {
		if(startI + (p.length - 1) >= g.length){
			return false;
		}
		for(int i = 0;i<p.length;i++) {
//			System.out.println(g[startI]);
//			System.out.println(p[i]);
//			System.out.println(" ");
			if( (startJ+(p[i].length()-1) >= g[startI].length()) || !g[startI].substring(startJ, startJ+(p[i].length())).equals(p[i]))
			{
				return false;
			}
			startI++;
		}
		return true;
	}
	public static void main(String[] args) {
		//System.out.println(new TheGridSearch().gridSearch(new String[] {"1234","4321","9999","9999"},new String[] {"21", "99"}));
		//System.out.println(new TheGridSearch().lengthOfLongestSubstring("aab"));
		int[] a = new int[3];
		for (int i : a) {
			System.out.println(i);
		}
		
	}
}
