package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxProductSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MaxProductSubArray().maxProduct(new int[]{2,3,-2,4}));
		System.out.println(new MaxProductSubArray().maxProduct(new int[]{-2,0,-1}));
		System.out.println(new MaxProductSubArray().maxProduct(new int[]{-4,-3,-2}));
		
	}
	
	public int maxProduct(int[] nums) {

		Map<Integer, Integer> indexToMaxPro = new HashMap<Integer, Integer>();
        int length = nums.length;
        for(int i = 0;i<length;i++) {
            indexToMaxPro.put(i, nums[i]);
        }
        if(length == 1) {
        	return nums[0];
        }
        int max = indexToMaxPro.get(length-1);
        int currVal, valWithNextEle, withNextEle;
        for(int i = length - 2; i>=0;i--) {
        	currVal = indexToMaxPro.get(i);
        	valWithNextEle = currVal * indexToMaxPro.get(i+1);
        	withNextEle = currVal * nums[i+1];
        	currVal = Math.max(valWithNextEle, currVal);
        	currVal = Math.max(withNextEle, currVal);
        	indexToMaxPro.put(i, currVal);
        	max = Math.max(max, currVal);
        	
        }
        return max;
    }

}
