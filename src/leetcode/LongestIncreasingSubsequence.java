package leetcode;

import java.util.HashMap;

public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = Integer.MIN_VALUE;
        int size = nums.length;
        for(int i = 0;i<nums.length;i++) {
            map.put(i, 1);
        }
        int currMax;
        for(int i = size - 2;i>=0;i--) {
        	currMax = Integer.MIN_VALUE;
        	for(int j = i+1;j<size;j++) {
        		if(nums[j] > nums[i] && currMax < (map.get(j)+1)) {
        			currMax = map.get(j) +1;
        		}
        	}
        	map.put(i, currMax);
        	max = Math.max(currMax, max);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
	}

}
