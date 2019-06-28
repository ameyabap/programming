package interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeParts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> parts = Arrays.asList(new Integer[]{8, 4, 6, 12});
		int ans = new MergeParts().minimumTime(4, parts);
		System.out.println(ans);
	}
	
	int minimumTime(int numOfParts, List<Integer> parts)
    {
		int res = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0;i<parts.size();i++) {
			pq.add(parts.get(i));
			
		}
		while(pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			res += first + second;
			pq.add(first + second);
		}
		
        return res;
        
    }

}
