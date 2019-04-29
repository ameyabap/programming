package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedMatrixSearch {

	public static void main(String[] args) {
/*
 * [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
 */
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(new ArrayList<Integer>(Arrays.asList(1,   3,  5,  7)));
		a.add(new ArrayList<Integer>(Arrays.asList(10, 11, 16, 20)));
		a.add(new ArrayList<Integer>(Arrays.asList(23, 30, 34, 50)));
		
		System.out.println(new SortedMatrixSearch().searchMatrix(a, 11));
	}
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int rows = a.size();
        int columns = a.size() > 0 ? a.get(0).size() : 0;
        int low = 0, high = rows-1, mid = -1;;
        int requiredRow = -1;
        while(low != high) {
        	mid = (low + high) /2;
        	if(b >= a.get(mid).get(0)) {
        		if(b <= a.get(mid).get(columns - 1) ){
        			requiredRow = mid;
        			break;
        		}else {
        			if(b >= a.get(high).get(0) ){
            			requiredRow = high;
            			break;
        			}else {
        				low = mid + 1;
        			}
        		}
        		
        	}else {
        		if(b <= a.get(low).get(columns - 1) ){
        			requiredRow = low;
        			break;
        		}else {
        			high = mid - 1;
        		}
        	}
        	requiredRow = low;
        }
        return isPresentIn(a.get(requiredRow), b) ? 1 : 0;
        
    }
	private boolean isPresentIn(ArrayList<Integer> arrayList, int b) {
		int low = 0, high = arrayList.size() - 1;
		int mid = -1;
		while(low <= high) {
			mid = (low + high) / 2;
			if(arrayList.get(mid) == b) {
				return true;
			}else if(b >= arrayList.get(mid)) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return false;
	}

}
