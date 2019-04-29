package hackerrank;

import java.util.Iterator;
import java.util.Stack;

public class MinMaxRiddle {

	// Complete the riddle function below.
    static long[] riddle(long[] arr) {
		long[] result = new long[arr.length];
    	for(int i = 1;i<=arr.length;i++) {
			Stack<Long> maxStack = new Stack<Long>();
			for(int j = 0;j+(i-1)<arr.length;j++) {
				Stack<Long> minStack = new Stack<Long>();
				for(int k = j;k<=j+(i-1);k++){
					if(minStack.isEmpty() || arr[k] < minStack.peek()) {
						minStack.push(arr[k]);
					}
				}
				if(maxStack.isEmpty() || minStack.peek() > maxStack.peek()){
					maxStack.push(minStack.pop());
				}
				
			}
			result[i-1] = maxStack.pop();
    	}
    	return result;
        // complete this function
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//long[] arr = riddle(new long[]{2,6,1,12});
		long[] arr = riddle(new long[]{1,2, 3, 5, 1, 13, 3});
		for (long l : arr) {
			System.out.println(l + " ");
		}

	}

}
