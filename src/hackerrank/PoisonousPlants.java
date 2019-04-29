package hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PoisonousPlants {

	static int poisonousPlants(int[] p) {
		//List<Integer> list = new LinkedList<Integer>();
		List<Integer> list = Arrays.stream(p).boxed().collect(Collectors.toList());

		int noOfDays = 0;
		Stack<Integer> indexes;
		int tillSize = list.size();
		indexes = new Stack<Integer>();
		while(true) {
			for(int i = 1;i<tillSize;i++) {
				if(list.get(i) > list.get(i-1)) {
					indexes.push(list.get(i));
				}
			}
			if(indexes.empty()) {
				break;
			}else {
				tillSize = indexes.peek() + 2;
//				while(!indexes.isEmpty()) {
//					list.remove((int)indexes.pop());
//				}
				list.removeAll(indexes);
				indexes.clear();
				noOfDays++;
			}
			tillSize = Math.min(tillSize, list.size());
		}
		
		
		return noOfDays;

    }
	public static void main(String[] args) {

		System.out.println(poisonousPlants(new int[]{6, 5, 8, 4, 7, 10, 9}));
	}

}
