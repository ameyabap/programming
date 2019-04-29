package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MedianOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Integer> a = new LinkedList<Integer>(Arrays.asList(-50, -41, -40, -19, 5, 21, 28));
//		List<Integer> b = new LinkedList<Integer>(Arrays.asList(-50, -21, -10));
		List<Integer> a = new LinkedList<Integer>(Arrays.asList(0, 23));
		List<Integer> b = new LinkedList<Integer>(Arrays.asList());
		System.out.println(new MedianOfArray().findMedianSortedArrays(a, b));
	}
	
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    
		int medianIndex =  ((a.size() + b.size())/2);
		
		int i = 0,j=0;
		int isFound = 0;
		List<Integer> combined = new LinkedList<Integer>();
		while(i<a.size() && j<b.size()) {
			
			if(a.get(i) <= b.get(j)) {
				combined.add(a.get(i++));
			}else {
				combined.add(b.get(j++));;
			}
			if(i+j-1 == medianIndex+1) {
				isFound = 1;
				break;
			}
		}
		if(isFound == 1) {
			if(((a.size() + b.size())%2==0)){
				return ((double)(combined.get(medianIndex)+combined.get(medianIndex-1))/(double)2);
			}
			return (double)(combined.get(medianIndex));
		}
		
		while(i<a.size()) {
			combined.add(a.get(i++));
		}
		
		while(j<b.size()) {
			combined.add(b.get(j++));
		}
		if(((a.size() + b.size())%2==0)){
			return ((double)(combined.get(medianIndex)+combined.get(medianIndex-1))/(double)2);
		}
		return (double)(combined.get(medianIndex));
		
    }

}
