package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}
	
	public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> stairToCost = new HashMap<Integer, Integer>();
        int size = cost.length;
        if(size == 0) {
        	return 0;
        }
        for(int i = 0;i<size;i++) {
        	stairToCost.put(i, Integer.MAX_VALUE);
        }
        int min = Integer.MAX_VALUE;
        int currMin = Integer.MAX_VALUE;
        int val = 0;int ithVal = 0;
        for(int i = size - 1; i>=0;i--) {
    		ithVal = stairToCost.get(i);
    		currMin = ithVal;
        	for(int j = i + 1;j < size && j <=i+2;j++) {
        		val = stairToCost.get(j);
        		currMin = Math.min(val+ithVal, currMin);
        	}
        	min = Math.min(currMin, min);
        	stairToCost.put(i,Math.min(currMin, ithVal));
        }
        return min;
    
    }

}
