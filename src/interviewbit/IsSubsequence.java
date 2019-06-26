package interviewbit;

public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
		System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
	}
	public boolean isSubsequence(String s, String t) {
		int prevIndex = 0, index;
		if(s.length() == 0) {
			return false;
		}
		for(int i = 0;i<s.length();i++) {
			index = t.indexOf(s.charAt(i), prevIndex); 
			if(index == -1) {
				return false;
			}
			prevIndex = index + 1;
		}
		return true;
		
    }

}
