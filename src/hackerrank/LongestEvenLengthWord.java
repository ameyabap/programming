package hackerrank;

import java.util.StringTokenizer;  

class LongestEvenLengthWord {

    /*
     * Complete the 'longestEvenWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING sentence as parameter.
     */
	public static void main(String[] args) {
		longestEvenWord("hey");
	}
    public static String longestEvenWord(String sentence) {
    // Write your code here
        StringTokenizer st = new StringTokenizer(sentence," ");
        String maxEvenLengthWord = "";
        String currentWord;
        int currentWordLength;
        while (st.hasMoreTokens()) {  
            currentWord = st.nextToken();
            currentWordLength = currentWord.length();
            if(currentWordLength % 2 == 0 && currentWordLength > maxEvenLengthWord.length()) {
            	maxEvenLengthWord = currentWord;
            }
        }  
        if(maxEvenLengthWord.length() % 2 != 0) {
        	return "00";
        }
		return maxEvenLengthWord;  
    }

}


