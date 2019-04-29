package tech9;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().solution("abc def ghi", 3));
		System.out.println(new Test().solution("ab cddfg", 3));
		System.out.println(new Test().solution("SMS messages are really short but need them", 12));

	}
//	 public int solution(String s, int k) {
//	    k = k-1;
//		int smsCount = 0; int counter = 0;
//	    if(s.length() > k && s.indexOf(' ') == -1){
//	    	return -1;
//	    }
//		while(counter < s.length()) {
//	    	if((counter+k) < s.length() && s.charAt(counter+k) == ' ') {
//	    		counter = counter+k+1;
//	    		smsCount++;
//	    	}
//	    	else if((counter+k+1 < s.length() && s.charAt(counter+k+1) == ' ') || (counter+k+1 == s.length())){
//	    			counter = counter+k+2;
//		    		smsCount++;
//	    		}
//	    	else {
//	    		if(counter+k < s.length()) {
//	    			
//		    		for(int i = counter+k;i>=0;i--){
//		    			if(s.charAt(i) == ' ') {
//		    				counter = i+1;
//		    				smsCount++;
//		    				break;
//		    			}
//		    		}
//	    		}else {
//	    			smsCount++;
//	    			counter = counter+k;
//	    		}
//	    		
//
//	    	}
//	    }
//	    return smsCount;
//	 }
	
	public int solution(String s, int k) {
		String[] arr = s.split(" ");
		int smsCount = 0;
		int temp = k;
		for (String str : arr) {
			
			if(str.length() > k && temp == k) {
				return -1;
			} 
			if(str.length() <= temp) {
				temp = temp - str.length() - 1;
			}
			else if(str.length() > temp && temp < k){
				smsCount++;
				temp = k;
				if(str.length() > k) {
					return -1;
				}else {
					temp = temp - str.length() - 1;
				}
			}
			
		}
		if(temp < k) {
			smsCount++;
		}
		return smsCount;
	}
}
