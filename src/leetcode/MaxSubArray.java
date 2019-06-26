package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1}));

	}
	
	public int maxSubArray(int[] nums) {
        //Map<Integer, Integer> indexToMaxSum = new HashMap<Integer, Integer>();
        int length = nums.length;
//        for(int i = 0;i<length;i++) {
//            indexToMaxSum.put(i, nums[i]);
//        }
        if(length == 1) {
        	return nums[0];
        }
        int max = nums[length-1];
        int currVal, valWithNextEle;
        for(int i = length - 2; i>=0;i--) {
        	currVal = nums[i];
        	valWithNextEle = currVal + nums[i+1];
        	if(valWithNextEle > currVal) {
        		currVal = valWithNextEle;
        		nums[i] = currVal;
        	}
        	max = Math.max(max, currVal);
        	
        }
        return max;
    }

}
