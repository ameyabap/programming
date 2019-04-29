package interviewbit;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Integer> a = Arrays.asList(4,5, 6, 7, 0, 1, 2);
		//List<Integer> a = Arrays.asList(4,5, 6, 7, 8, 9, 1,2,3);
		//List<Integer> a = Arrays.asList(180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177);
		List<Integer> a = Arrays.asList(9, 10, 11, 12, 14, 15, 17, 19, 24, 25, 30, 39, 40, 44, 46, 48, 51, 53, 54, 56, 59, 60, 69, 70, 73, 75, 80, 87, 88, 89, 92, 93, 97, 
				99, 104, 107, 109, 110, 111, 117, 123, 124, 125, 126, 127, 128, 135, 136, 137, 141, 148, 153, 154, 161, 166, 167, 169, 175, 177, 180, 181, 182, 185, 186, 189, 
				193, 198, 202, 1, 2, 6, 7);

		System.out.println(new RotatedSortedArraySearch().search(a, 198));
	}
	
	// DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
    	
    	int low = 0, high = a.size() -1;
    	int mid;
    	while(low <= high) {
    		mid = (low + high)/2;
    		System.out.println("low- " + a.get(low));
    		System.out.println("mid- " + a.get(mid));
    		System.out.println("high- " + a.get(high));

    		if(a.get(mid) == b) {
    			return mid;
    		}
    		if(a.get(low) <= a.get(high)) {
    			if(a.get(mid) > b) {
    				high = mid - 1;
    			}else {
    				low = mid + 1;
    			}
    		}
    		else if(a.get(mid) > b) {
    			high = mid - 1;
    		}else {
    			low = mid + 1;
    		}
//    		if((a.get(low) <= a.get(mid) && b >= a.get(low) && b < a.get(mid)) || (a.get(low) < b && a.get(mid) < b && a.get(high) < b)) {
//    			high = mid - 1;
//    		}else {
//    			low = mid + 1;
//    		}
    		
    	}
    	return -1;
    }

}
