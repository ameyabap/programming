package interviewbit;

public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
	public static int isPalindrome(String A) {
        int i = 0, j = A.length()-1;
        while(i <= j) {
            //int frontCharacter = Character.toLowerCase(A.charAt(i));
            while(i<A.length() && !Character.isDigit(A.charAt(i)) &&  !Character.isLetter(A.charAt(i))){
                i++;
//                if(i<A.length())
//                    frontCharacter = (int)Character.toLowerCase(A.charAt(i));
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
