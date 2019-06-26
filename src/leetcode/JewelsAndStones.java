package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class JewelsAndStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));

	}
	
	public int numJewelsInStones(String J, String S) {
		J.toLowerCase();
		Set<Character> jewels = new HashSet<Character>();
		for (int i = 0; i < J.length(); i++) {
			jewels.add(J.charAt(i));
		}
		
		int count = 0;
		for(int i = 0;i<S.length();i++) {
			if(jewels.contains(S.charAt(i))) {
				count++;
			}
		}
		return count;
    }
}
