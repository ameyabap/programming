package hackerrank;

public class LargestRectangle {

	// Complete the largestRectangle function below.
    static long getElementsToLeft(int[] h, int index) {
    	int count = 0;
    	for(int i = index-1; i>=0;i--) {
    		if(h[i] < h[index]){
    			break;
    		}
    		count++;
    	}
    	return count;
    }
    
    static long getElementsToRight(int[] h, int index) {
    	int count = 0;
    	for(int i = index+1; i< h.length;i++) {
    		if(h[i] < h[index]){
    			break;
    		}
    		count++;
    	}
    	return count;
    }
	static long largestRectangle(int[] h) {
        long max = Long.MIN_VALUE;
		long current;
        for(int i = 0;i<h.length;i++) {
        	current = (getElementsToLeft(h, i) + getElementsToRight(h, i) + 1) * h[i];
        	max = (current > max) ? current : max;
        }
        return max;
    }
    
	public static void main(String[] args) {
		int[] arr = new int[]{1, 3, 5, 9, 11};
		System.out.println(largestRectangle(arr));
	}

}
