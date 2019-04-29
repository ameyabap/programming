package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {

	public int searchInsert(ArrayList<Integer> a, int b) {
	    int low = 0; int high = a.size() - 1;
	    int mid;
	    if(b < a.get(0)) {
	    	return 0;
	    }else if(b > a.get(a.size()-1)) {
	    	return a.size();
	    }
	    while(low <= high) {
	        mid = (low + high)/2;
	        if(a.get(mid) == b) {
	            return mid;
	        }
	        if(b < a.get(mid)){
	            high = mid - 1;
	        }else {
	            low = mid+1;
	        }
	    }
//	    if(a.get(low) == b) {
//	        return low;
//	    }else if(b<a.get(low)){
//	        return (low - 1 < 0)? low : low -1;
//	        
//	    }else {
//	        return ((high + 1) >= a.size())? low : low +1;
//	    }
	    return low;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SortedInsertPosition().searchInsert(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 6 )), 7));
	}

}
