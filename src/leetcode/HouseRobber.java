package leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new HouseRobber().rob(new int[]{2,7,9,3,1}));
		System.out.println(new HouseRobber().rob(new int[]{1,2,3,1}));
		System.out.println(new HouseRobber().rob(new int[]{}));
		System.out.println(new HouseRobber().rob(new int[]{2}));

	}
	
	public int rob(int[] nums) {
        Map<Integer, Integer> houseToAmt = new HashMap<Integer, Integer>();
        int size = nums.length;
        if(size == 0) {
        	return 0;
        }
        for(int i = 0;i<size;i++) {
        	houseToAmt.put(i, nums[i]);
        }
        int max = Integer.MIN_VALUE;
        int currMax = Integer.MIN_VALUE;
        int val = 0;int ithVal = 0;
        for(int i = size - 1; i>=0;i--) {
    		ithVal = houseToAmt.get(i);
    		currMax = ithVal;
        	for(int j = i + 2;j < size;j++) {
        		val = houseToAmt.get(j);
        		currMax = Math.max(val+ithVal, currMax);
        	}
        	max = Math.max(currMax, max);
        	houseToAmt.put(i,Math.max(currMax, ithVal));
        }
        return max;
    }

}
