package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixMedian {

	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,3,5));
		ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(2,6,9));
		ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(3,6,9));
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(list1);
		A.add(list2);
		A.add(list3);
		System.out.println(new MatrixMedian().findMedian(A));
	}
    public int getIndex(ArrayList<Integer> list, int val) {
        int high = list.size() - 1; int low = 0;
        int mid;
        while(low<=high) {
            mid = (low + high) / 2;
            if(list.get(mid) == val) {
                return mid;
            }else if(list.get(mid) < val) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
    int numbersLessThan(ArrayList<Integer> a, int num) {
		int count = 0;
    	for(int i : a) {
    		if(i >= num) {
    			break;
    		}
    		count++;
    	}
    	return count;
    	
    }
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int columns = 0;
        for(ArrayList<Integer> list : A) {
            columns = list.size();
            if(list.get(0) < min) {
                min = list.get(0);
            }
            if(list.get(columns - 1) > max) {
                max = list.get(columns - 1);
            }
        }
        System.err.println(min + " " + max);


        int requiredSmallerNumbers = (((A.size() * columns) + 1)/2) - 1;
        while(min <= max) {
            int mid = (min + max) / 2;
            int placesSmallerThanMid = 0;
            for(ArrayList<Integer> list : A) {
                int index = getIndex(list, mid);
                if(index == -1) {
                    placesSmallerThanMid += (numbersLessThan(list, mid));
                }else {
                    placesSmallerThanMid += index;
                }
            }
            if(placesSmallerThanMid < requiredSmallerNumbers) {
                min = mid + 1;
             }else if(placesSmallerThanMid == requiredSmallerNumbers){
                
                 return mid;
            }else {
                max = mid - 1;
            }
        }
        return min;
        // get median index
        
    }
    
}

