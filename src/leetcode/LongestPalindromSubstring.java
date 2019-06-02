/**
 * 
 */
package leetcode;

/**
 * @author ameyabapat
 *
 */
public class LongestPalindromSubstring {
	//NOT Yet DONE:
	public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0) {
            return "";
        }else if(n == 1) {
            return s;
        }
        int[][] arr = new int[n][n];
        int i = 0;int j = n-1;
        for(i = 0;i<n;i++) {
        	arr[i][i] = 1;
        }
        int k = 0;
		while (k < n) {
			i = 0;j = k;
			
			while(n-j > 0) {
					if(i == j){
						arr[i][j] = 1;
					}else if (s.charAt(i) == s.charAt(j)) {
						arr[i][j] = 2 + arr[i + 1][j - 1];
					} else {
						arr[i][j] = Math.max(arr[i][j - 1], arr[i + 1][j]);
					}
					i++;j++;
			}
			k++;
		}
         for(i = 0;i<n;i++) {
         	for(j = 0;j<n;j++) {
         		System.out.print(arr[i][j] + " ");
         	}
         	System.out.print("\n");
         }
        boolean canStop = false;
        i = 0; j = n-1;
        while(canStop == false && (i+1 < n) && (j-1 >=0) ) {
        	 if(arr[i][j] == arr[i][j-1]){
        		j = j-1;
        	}else if(arr[i][j] == arr[i+1][j]) {
        		i = i+1;
        	}else if(arr[i][j]==arr[i+1][j-1] + 2){
        		canStop = true;
        	}
        }
        if(canStop == true) 
            return s.substring(i, j+1);
        else 
            return s.substring(0,1);
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(new LongestPalindromSubstring().longestPalindrome("babad"));
//		System.out.println(new LongestPalindromSubstring().longestPalindrome("cbbd"));
		System.out.println(new LongestPalindromSubstring().longestPalindrome("abcda"));
	}
	

}
