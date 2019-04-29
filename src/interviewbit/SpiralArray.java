package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SpiralArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);a.add(2);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(3);b.add(4);
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(5);c.add(6);
		
		List<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		arr.add(a);
		arr.add(b);
		arr.add(c);
		spiralOrder(arr);
	}
	    // DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int l = 0, r = A.get(0).size()-1, b=A.size()-1, t = 0;
            int x = 0, y=0;
            boolean canMove = true;
            ArrayList<Integer> result = new ArrayList<Integer>();
            int previous = 0;
            while(canMove) {
                previous = y;
                while(y <= r) {
                    result.add(A.get(x).get(y++));
                }
                if(Math.abs(previous-y) <=1) {
                    canMove = false;
                    break;
                }else{
                    y--;
                    x++;
                    r--;
                }
                
                previous = x;
                while(x <= b) {
                    result.add(A.get(x++).get(y));
                }
                if(Math.abs(previous-x) <=1) {
                    canMove = false;
                    break;
                }else{
                    x--;
                    y--;
                    b--;
                }
                
                previous = y;
                while(y >= l) {
                    result.add(A.get(x).get(y--));
                }
                if(Math.abs(previous-y) <=1) {
                    canMove = false;
                    break;
                }else{
                    y++;
                    x--;
                    l++;
                }
                
                
                previous = x;
                while(x >= t) {
                    result.add(A.get(x--).get(y));
                }
                if(Math.abs(previous-x) <=1) {
                    canMove = false;
                    break;
                }else{
                    x++;
                    y++;
                    t++;
                }
                
                
            }
            return result;
    }
	

}
